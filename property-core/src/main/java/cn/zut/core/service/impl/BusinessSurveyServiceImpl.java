package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessSurveyService;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;
import cn.zut.dao.persistence.BusinessSurveyAnswersMapper;
import cn.zut.dao.persistence.BusinessSurveyDataMapper;
import cn.zut.dao.persistence.BusinessSurveyMapper;
import cn.zut.facade.response.SurveyAllVO;
import cn.zut.facade.response.SurveyAnswerVO;
import cn.zut.facade.response.SurveyDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@Service("businessSurveyService")
public class BusinessSurveyServiceImpl implements BusinessSurveyService {

    @Resource
    private BusinessSurveyMapper businessSurveyMapper;
    @Resource
    private BusinessSurveyDataMapper businessSurveyDataMapper;
    @Resource
    private BusinessSurveyAnswersMapper businessSurveyAnswersMapper;

    @Override
    public List<BusinessSurveyEntity> findAll() {
        return businessSurveyMapper.selectListByExample(null);
    }

    @Override
    public BusinessSurveyEntity addSurvey() {
        BusinessSurveyEntity businessSurveyEntity = new BusinessSurveyEntity();
        businessSurveyMapper.insert(businessSurveyEntity);
        return businessSurveyEntity;
    }

    @Override
    public BusinessSurveyDataEntity addSurveyData(Integer surveyId) {
        BusinessSurveyDataEntity businessSurveyDataEntity = new BusinessSurveyDataEntity();
        businessSurveyDataEntity.setSurveyId(surveyId);
        businessSurveyDataMapper.insert(businessSurveyDataEntity);
        return businessSurveyDataEntity;
    }

    @Override
    public BusinessSurveyAnswersEntity addSurveyAnswers(BusinessSurveyDataEntity businessSurveyDataEntity) {
        businessSurveyDataEntity = businessSurveyDataMapper.selectByExample(businessSurveyDataEntity);
        if (businessSurveyDataEntity == null) {
            return null;
        }

        BusinessSurveyAnswersEntity businessSurveyAnswersEntity = new BusinessSurveyAnswersEntity();
        businessSurveyAnswersEntity.setQuestionId(businessSurveyDataEntity.getQuestionId());
        businessSurveyAnswersMapper.insert(businessSurveyAnswersEntity);

        return businessSurveyAnswersEntity;
    }

    /**
     * 添加答案选项
     */
    @Override
    public BusinessSurveyAnswersEntity adnSurveyAnswer(BusinessSurveyAnswersEntity businessSurveyAnswersEntity) {
        businessSurveyAnswersMapper.update(businessSurveyAnswersEntity);

        return businessSurveyAnswersMapper.selectById(businessSurveyAnswersEntity.getAnswerId());
    }

    @Override
    public BusinessSurveyDataEntity addSurveyDate(BusinessSurveyDataEntity businessSurveyDataEntity) {
        businessSurveyDataMapper.update(businessSurveyDataEntity);

        return businessSurveyDataMapper.selectById(businessSurveyDataEntity.getQuestionId());
    }

    /**
     * 添加调查
     */
    @Override
    public BusinessSurveyEntity addSurveyName(BusinessSurveyEntity businessSurveyEntity) {
        businessSurveyMapper.update(businessSurveyEntity);

        return businessSurveyMapper.selectById(businessSurveyEntity.getSurveyId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delSurvey(Integer surveyId) {

        BusinessSurveyDataEntity businessSurveyDataEntity = new BusinessSurveyDataEntity();
        businessSurveyDataEntity.setSurveyId(surveyId);
        List<BusinessSurveyDataEntity> list = businessSurveyDataMapper.selectListByExample(businessSurveyDataEntity);
        for (BusinessSurveyDataEntity surveyData : list) {
            businessSurveyDataMapper.deleteById(surveyData.getSurveyId());
        }

        businessSurveyMapper.deleteById(surveyId);

        return true;
    }

    @Override
    public Map<String, Object> selectService() {
        List<SurveyAllVO> surveyAllVOS = new ArrayList<>();

        List<BusinessSurveyEntity> businessSurveyEntities = businessSurveyMapper.selectListByExample(null);
        businessSurveyEntities.forEach(businessSurveyEntity -> {
            SurveyAllVO surveyAllVO = new SurveyAllVO();
            surveyAllVO.setTitle(businessSurveyEntity.getTitle());
            surveyAllVO.setDescription(businessSurveyEntity.getDescription());

            List<SurveyDataVO> surveyDataVOS = new ArrayList<>();

            BusinessSurveyDataEntity surveyDataSearch = new BusinessSurveyDataEntity();
            surveyDataSearch.setSurveyId(businessSurveyEntity.getSurveyId());
            List<BusinessSurveyDataEntity> businessSurveyDataEntities = businessSurveyDataMapper.selectListByExample(surveyDataSearch);
            businessSurveyDataEntities.forEach(businessSurveyDataEntity -> {
                SurveyDataVO surveyDataVO = new SurveyDataVO();
                surveyDataVO.setAnswerType(businessSurveyDataEntity.getAnswerType());
                surveyDataVO.setQuestion(businessSurveyDataEntity.getQuestion());

                List<SurveyAnswerVO> surveyAnswerVOS = new ArrayList<>();

                BusinessSurveyAnswersEntity surveyAnswersSearch = new BusinessSurveyAnswersEntity();
                surveyAnswersSearch.setQuestionId(businessSurveyDataEntity.getQuestionId());
                List<BusinessSurveyAnswersEntity> businessSurveyAnswersEntities = businessSurveyAnswersMapper.selectListByExample(surveyAnswersSearch);
                businessSurveyAnswersEntities.forEach(businessSurveyAnswersEntity -> {
                    SurveyAnswerVO surveyAnswerVO = new SurveyAnswerVO();
                    surveyAnswerVO.setPoll(businessSurveyAnswersEntity.getPoll());
                    surveyAnswerVO.setChoiceText(businessSurveyAnswersEntity.getChoiceText());

                    surveyAnswerVOS.add(surveyAnswerVO);
                });

                surveyDataVO.setSurveyAnswerVOList(surveyAnswerVOS);
                surveyDataVOS.add(surveyDataVO);
            });

            surveyAllVO.setSurveyDataList(surveyDataVOS);
            surveyAllVOS.add(surveyAllVO);
        });

        Map<String, Object> map = new HashMap<>(1);
        map.put("surveyAll", surveyAllVOS);
        return map;
    }
}

package cn.zut.core.service.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessSurveyService;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;
import cn.zut.dao.persistence.BusinessSurveyAnswersMapper;
import cn.zut.dao.persistence.BusinessSurveyDataMapper;
import cn.zut.dao.persistence.BusinessSurveyMapper;
import cn.zut.facade.response.SurveyAllVO;
import cn.zut.facade.response.SurveyAnswerVO;
import cn.zut.facade.response.SurveyDataSimpleVO;
import cn.zut.facade.response.SurveyDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public List<BusinessSurveyEntity> findAllSurvey() {
        return businessSurveyMapper.selectListByExample(null);
    }

    @Override
    public GenericResponse addSurvey(BusinessSurveyEntity businessSurveyEntity) {
        int flag = businessSurveyMapper.insert(businessSurveyEntity);
        return flag > 0 ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    @Override
    public GenericResponse addSurveyDate(BusinessSurveyDataEntity businessSurveyDataEntity) {
        if (businessSurveyMapper.selectById(businessSurveyDataEntity.getSurveyId()) == null) {
            return GenericResponse.ERROR_PARAM;
        }

        int flag = businessSurveyDataMapper.insert(businessSurveyDataEntity);
        return flag > 0 ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    @Override
    public GenericResponse addSurveyAnswers(BusinessSurveyAnswersEntity businessSurveyAnswersEntity) {
        if (businessSurveyDataMapper.selectById(businessSurveyAnswersEntity.getQuestionId()) == null) {
            return GenericResponse.ERROR_PARAM;
        }
        BusinessSurveyAnswersEntity search = new BusinessSurveyAnswersEntity();
        search.setMemberId(businessSurveyAnswersEntity.getMemberId());
        search.setQuestionId(businessSurveyAnswersEntity.getQuestionId());
        BusinessSurveyAnswersEntity oldSurveyAnswersEntity = businessSurveyAnswersMapper.selectByExample(search);

        int flag;
        if (oldSurveyAnswersEntity != null) {
            oldSurveyAnswersEntity.setChoiceText(businessSurveyAnswersEntity.getChoiceText());
            flag = businessSurveyAnswersMapper.update(oldSurveyAnswersEntity);
        } else {
            flag = businessSurveyAnswersMapper.insert(businessSurveyAnswersEntity);
        }

        return flag > 0 ? GenericResponse.SUCCESS : GenericResponse.FAIL;
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
    public GenericResponse<List<SurveyAllVO>> allSurveyBaseData() {
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

                surveyDataVOS.add(surveyDataVO);
            });

            surveyAllVO.setSurveyDataList(surveyDataVOS);
            surveyAllVOS.add(surveyAllVO);
        });

        return new GenericResponse<>(surveyAllVOS);
    }

    @Override
    public GenericResponse<SurveyAllVO> surveyDataBySurveyId(Integer surveyId) {
        BusinessSurveyEntity businessSurveyEntity = businessSurveyMapper.selectById(surveyId);

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

            surveyDataVOS.add(surveyDataVO);
        });

        surveyAllVO.setSurveyDataList(surveyDataVOS);

        return new GenericResponse<>(surveyAllVO);
    }

    @Override
    public GenericResponse<List<SurveyDataSimpleVO>> allSurveyData(Integer surveyId, Long memberId) {
        List<SurveyDataSimpleVO> surveyDataVOS = new ArrayList<>();

        BusinessSurveyDataEntity surveyDataSearch = new BusinessSurveyDataEntity();
        surveyDataSearch.setSurveyId(surveyId);
        List<BusinessSurveyDataEntity> businessSurveyDataEntities = businessSurveyDataMapper.selectListByExample(surveyDataSearch);
        businessSurveyDataEntities.forEach(businessSurveyDataEntity -> {
            SurveyDataSimpleVO surveyDataVO = new SurveyDataSimpleVO();
            surveyDataVO.setAnswerType(businessSurveyDataEntity.getAnswerType());
            surveyDataVO.setQuestion(businessSurveyDataEntity.getQuestion());
            surveyDataVO.setQuestionId(businessSurveyDataEntity.getQuestionId());

            BusinessSurveyAnswersEntity surveyAnswersSearch = new BusinessSurveyAnswersEntity();
            surveyAnswersSearch.setQuestionId(businessSurveyDataEntity.getQuestionId());
            surveyAnswersSearch.setMemberId(memberId);
            BusinessSurveyAnswersEntity businessSurveyAnswersEntity = businessSurveyAnswersMapper.selectByExample(surveyAnswersSearch);
            if (businessSurveyAnswersEntity != null) {
                SurveyAnswerVO surveyAnswerVO = new SurveyAnswerVO();
                surveyAnswerVO.setPoll(businessSurveyAnswersEntity.getPoll());
                surveyAnswerVO.setChoiceText(businessSurveyAnswersEntity.getChoiceText());
                surveyAnswerVO.setMemberId(businessSurveyAnswersEntity.getMemberId());

                surveyDataVO.setSurveyAnswer(surveyAnswerVO);
            }
            surveyDataVOS.add(surveyDataVO);
        });

        return new GenericResponse<>(surveyDataVOS);
    }
}

package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;
import cn.zut.facade.response.SurveyAllVO;
import cn.zut.facade.response.SurveyDataSimpleVO;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessSurveyService {

    /**
     * 查询所有问卷
     *
     * @return 问卷List
     */
    List<BusinessSurveyEntity> findAllSurvey();

    /**
     * 添加问卷
     *
     * @param businessSurveyEntity 问卷实体
     * @return 添加状态
     */
    GenericResponse addSurvey(BusinessSurveyEntity businessSurveyEntity);

    /**
     * 添加问题
     *
     * @param businessSurveyDataEntity 问题实体
     * @return 添加状态
     */
    GenericResponse addSurveyDate(BusinessSurveyDataEntity businessSurveyDataEntity);

    /**
     * 添加回答
     *
     * @param businessSurveyAnswersEntity 回答实体
     * @return 添加状态
     */
    GenericResponse addSurveyAnswers(BusinessSurveyAnswersEntity businessSurveyAnswersEntity);

    /**
     * 删除问卷
     *
     * @param surveyId 问卷编号
     * @return 删除状态
     */
    boolean delSurvey(Integer surveyId);

    /**
     * 查看所有问卷 + 问题
     *
     * @return 问卷以及问题以及回答
     */
    GenericResponse<List<SurveyAllVO>> allSurveyBaseData();

    /**
     * 查看所有问卷 + 问题
     *
     * @param surveyId 问卷id
     * @return 问卷以及问题以及回答
     */
    GenericResponse<SurveyAllVO> surveyDataBySurveyId(Integer surveyId);

    /**
     * 获取问题 + 回答
     *
     * @param surveyId 问卷id
     * @param memberId 用户编号
     * @return 问题 + 回答
     */
    GenericResponse<List<SurveyDataSimpleVO>> allSurveyData(Integer surveyId, Long memberId);
}

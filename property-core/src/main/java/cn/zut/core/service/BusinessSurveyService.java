package cn.zut.core.service;

import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
public interface BusinessSurveyService {
    List<BusinessSurveyEntity> findAll();

    BusinessSurveyEntity addSurvey();

    BusinessSurveyDataEntity addSurveyData(Integer surveyId);

    BusinessSurveyAnswersEntity addSurveyAnswers(BusinessSurveyDataEntity businessSurveyDataEntity);

    BusinessSurveyAnswersEntity adnSurveyAnswer(BusinessSurveyAnswersEntity businessSurveyAnswersEntity);

    BusinessSurveyDataEntity addSurveyDate(BusinessSurveyDataEntity businessSurveyDataEntity);

    BusinessSurveyEntity addSurveyName(BusinessSurveyEntity businessSurveyEntity);

    boolean delSurvey(Integer surveyid);

    Map<String, Object> selectService();
}

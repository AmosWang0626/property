package cn.zut.dao.entity;

import lombok.Data;

/**
 * @author LiuBowen
 */
@Data
public class BusinessSurveyDataEntity {

    private Integer surveyId;

    private Integer questionId;

    private String question;

    private Boolean answerType;
}
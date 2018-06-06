package cn.zut.facade.response;

import lombok.Data;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/8
 */
@Data
public class SurveyDataSimpleVO {
    /**
     * 问题id
     */
    private Integer questionId;
    /**
     * 问题
     */
    private String question;
    /**
     * 回答类型
     */
    private String answerType;
    /**
     * 回答列表
     */
    private SurveyAnswerVO surveyAnswer;
    /**
     * 临时字段
     */
    private String choiceText;

}

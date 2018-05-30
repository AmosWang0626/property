package cn.zut.facade.response;

import lombok.Data;

import java.util.List;

/**
 * PROJECT: property2
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/8
 */
@Data
public class SurveyDataVO {
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
    private List<SurveyAnswerVO> surveyAnswerVOList;

}

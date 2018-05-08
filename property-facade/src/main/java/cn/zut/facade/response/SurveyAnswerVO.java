package cn.zut.facade.response;

import lombok.Data;

/**
 * PROJECT: property2
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/8
 */
@Data
public class SurveyAnswerVO {
    /**
     * 回答人
     */
    private Long memberId;
    /**
     * 答案
     */
    private String choiceText;
    /**
     * 回答人
     */
    private Integer poll;

}

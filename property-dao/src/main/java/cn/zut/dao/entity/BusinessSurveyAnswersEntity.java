package cn.zut.dao.entity;

import lombok.Data;

/**
 * @author LiuBowen
 * get set 方法统统不要,加个注解 @Data
 * 名字注意命名规范-驼峰命名
 * (毕竟代码是给人看的,是吧?)
 */
@Data
public class BusinessSurveyAnswersEntity {

    private Integer answerId;

    private Integer questionId;

    private String choiceText;

    private Integer poll;
}
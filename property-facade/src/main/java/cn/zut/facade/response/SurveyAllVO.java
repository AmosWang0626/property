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
public class SurveyAllVO {
    /**
     * 调查问卷标题
     */
    private String title;
    /**
     * 调查问卷描述
     */
    private String description;
    /**
     * 问题列表
     */
    private List<SurveyDataVO> surveyDataList;

}

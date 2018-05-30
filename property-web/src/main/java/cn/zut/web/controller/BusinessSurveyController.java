package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessSurveyService;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("survey")
public class BusinessSurveyController {

    @Resource
    private BusinessSurveyService businessSurveyService;

    @RequestMapping("allSurvey")
    public GenericResponse allSurvey() {
        return new GenericResponse<>(businessSurveyService.findAllSurvey());
    }

    /**
     * 添加问卷
     */
    @RequestMapping(value = "addSurvey", method = RequestMethod.POST)
    public GenericResponse addSurvey(@RequestBody BusinessSurveyEntity businessSurveyEntity) {
        if (StringUtils.isAnyBlank(businessSurveyEntity.getTitle(), businessSurveyEntity.getDescription())) {
            return GenericResponse.ERROR_PARAM;
        }
        return businessSurveyService.addSurvey(businessSurveyEntity);
    }

    /**
     * 添加问题
     */
    @RequestMapping(value = "addQues", method = RequestMethod.POST)
    public GenericResponse addQues(@RequestBody BusinessSurveyDataEntity businessSurveyDataEntity) {
        if (businessSurveyDataEntity.getSurveyId() == null || StringUtils.isAnyBlank(
                businessSurveyDataEntity.getQuestion(), businessSurveyDataEntity.getAnswerType())) {
            return GenericResponse.ERROR_PARAM;
        }

        return businessSurveyService.addSurveyDate(businessSurveyDataEntity);
    }

    /**
     * 添加回答
     */
    @RequestMapping("addAnswers")
    public GenericResponse addAnswers(@RequestBody BusinessSurveyAnswersEntity businessSurveyAnswersEntity, HttpServletRequest request) {
        if (businessSurveyAnswersEntity.getQuestionId() == null) {
            return GenericResponse.ERROR_PARAM;
        }
        if (businessSurveyAnswersEntity.getPoll() == null
                && StringUtils.isBlank(businessSurveyAnswersEntity.getChoiceText())) {
            return GenericResponse.ERROR_PARAM;
        }
        businessSurveyAnswersEntity.setMemberId(getMemberId(request));

        return businessSurveyService.addSurveyAnswers(businessSurveyAnswersEntity);
    }

    /**
     * 查询所有问卷数据
     *
     * @param request HttpServletRequest
     * @return GenericResponse
     */
    @RequestMapping("allSurveyData")
    public List<BusinessSurveyEntity> allSurveyData(HttpServletRequest request) {
        return businessSurveyService.findAllSurvey();
    }

    /**
     * 查询所有问卷数据
     *
     * @return GenericResponse
     */
    @RequestMapping("allSurveyBaseData")
    public GenericResponse allSurveyBaseData() {
        return businessSurveyService.allSurveyBaseData();
    }

    /**
     * 删除问卷
     *
     * @param businessSurveyEntity 问卷编号
     */
    @RequestMapping("del")
    public GenericResponse searchDel(@RequestBody BusinessSurveyEntity businessSurveyEntity) {
        return businessSurveyService.delSurvey(businessSurveyEntity.getSurveyId())? GenericResponse.SUCCESS:GenericResponse.FAIL;
    }

/*
*
* 获取
*
* */
    @RequestMapping("getQuestion")
    public GenericResponse searchGet(@RequestBody BusinessSurveyEntity businessSurveyEntity) {
        return new GenericResponse<>(businessSurveyService.getSurvey(businessSurveyEntity.getSurveyId()));
    }



    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}

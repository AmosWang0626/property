package cn.zut.web.controller;

import cn.zut.core.service.BusinessSurveyService;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;
import cn.zut.dao.entity.BusinessSurveyDataEntity;
import cn.zut.dao.entity.BusinessSurveyEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("survey")
public class BusinessSurveyController {

    @Resource
    private BusinessSurveyService businessSurveyService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> searchList() {
        List<BusinessSurveyEntity> list = businessSurveyService.findAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("msg", "");
        resultMap.put("code", "0");
        return resultMap;
    }

    @RequestMapping("addSurvey")
    public String addSurvey(HttpServletRequest request) {
        BusinessSurveyEntity businessSurveyEntity = businessSurveyService.addSurvey();
        request.setAttribute("search", businessSurveyEntity);
        return "addSearch";
    }

    @RequestMapping("addQuestion")
    public String addQuestion(@RequestParam("surveyId") Integer surveyId, HttpServletRequest request) {
        BusinessSurveyDataEntity businessSurveyDataEntity = businessSurveyService.addSurveyData(surveyId);
        request.setAttribute("question", businessSurveyDataEntity);
        return "addSearchQuestion";
    }

    @RequestMapping("addAnswers")
    public String addAnswers(BusinessSurveyDataEntity businessSurveyDataEntity, HttpServletRequest request) {
        BusinessSurveyAnswersEntity businessSurveyAnswersEntity = businessSurveyService.addSurveyAnswers(businessSurveyDataEntity);
        request.setAttribute("businessSurveyAnswersEntity", businessSurveyAnswersEntity);
        return "addSearchAnswers";
    }

    /**
     * 添加答案选项
     */
    @RequestMapping("addAns")
    public String addAns(BusinessSurveyAnswersEntity businessSurveyAnswersEntity, HttpServletRequest request) {
        businessSurveyAnswersEntity = businessSurveyService.adnSurveyAnswer(businessSurveyAnswersEntity);
        if (businessSurveyAnswersEntity != null) {
            request.setAttribute("surveyanswersMsg", "添加成功！");
            request.setAttribute("businessSurveyAnswersEntity", businessSurveyAnswersEntity);
            return "addSearchAnswers";
        }
        return "parameterError";
    }

    /**
     * 添加问题选项
     */
    @RequestMapping("addQues")
    public String addQues(BusinessSurveyDataEntity businessSurveyDataEntity, HttpServletRequest request) {
        BusinessSurveyDataEntity businessSurveyDataEntity1 = businessSurveyService.addSurveyDate(businessSurveyDataEntity);
        if (businessSurveyDataEntity1 != null) {
            request.setAttribute("questionMsg", "添加成功！");
            request.setAttribute("question", businessSurveyDataEntity1);
            return "addSearchQuestion";
        }
        return "parameterError";
    }

    @RequestMapping("addSearch")
    public String newSearch(BusinessSurveyEntity businessSurveyEntity, HttpServletRequest request) {
        BusinessSurveyEntity businessSurveyEntity1 = businessSurveyService.addSurveyName(businessSurveyEntity);
        if (businessSurveyEntity1 != null) {
            request.setAttribute("searchMsg", "添加成功！");
            request.setAttribute("search", businessSurveyEntity1);
            return "addSearch";
        }
        return "parameterError";
    }

    @RequestMapping("dosearch")
    public String doSearch(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map = businessSurveyService.selectService();
        request.setAttribute("searchMsg", map.get("searchMsg"));
        request.setAttribute("question", map.get("question"));
        request.setAttribute("answer", map.get("answer"));
        return "search";
    }

    @RequestMapping("del")
    public boolean searchDel(int surveyid) {
        return businessSurveyService.delSurvey(surveyid);
    }
}

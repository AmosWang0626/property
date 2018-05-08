package cn.zut.web.controller;

import cn.zut.core.service.SearchService;
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
@RequestMapping("search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping("searchlist")
    @ResponseBody
    public Map<String, Object> searchList() {
        List<BusinessSurveyEntity> list = searchService.findAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("msg", "");
        resultMap.put("code", "0");
        return resultMap;
    }

    @RequestMapping("addSurvey")
    public String addSurvey(HttpServletRequest request) {
        BusinessSurveyEntity businessSurveyEntity = searchService.addSurvey();
        request.setAttribute("search", businessSurveyEntity);
        return "addSearch";
    }

    @RequestMapping("addQuestion")
    public String addQuestion(@RequestParam("surveyId") Integer surveyId, HttpServletRequest request) {
        BusinessSurveyDataEntity businessSurveyDataEntity = searchService.addSurveyData(surveyId);
        request.setAttribute("question", businessSurveyDataEntity);
        return "addSearchQuestion";
    }

    @RequestMapping("addAnswers")
    public String addAnswers(BusinessSurveyDataEntity businessSurveyDataEntity, HttpServletRequest request) {
        BusinessSurveyAnswersEntity businessSurveyAnswersEntity = searchService.addSurveyAnswers(businessSurveyDataEntity);
        request.setAttribute("businessSurveyAnswersEntity", businessSurveyAnswersEntity);
        return "addSearchAnswers";
    }

    /**
     * 添加答案选项
     */
    @RequestMapping("addans")
    public String addAns(BusinessSurveyAnswersEntity businessSurveyAnswersEntity, HttpServletRequest request) {
        businessSurveyAnswersEntity = searchService.adnSurveyAnswer(businessSurveyAnswersEntity);
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
        BusinessSurveyDataEntity businessSurveyDataEntity1 = searchService.addSurveyDate(businessSurveyDataEntity);
        if (businessSurveyDataEntity1 != null) {
            request.setAttribute("questionMsg", "添加成功！");
            request.setAttribute("question", businessSurveyDataEntity1);
            return "addSearchQuestion";
        }
        return "parameterError";
    }

    @RequestMapping("addSearch")
    public String newSearch(BusinessSurveyEntity businessSurveyEntity, HttpServletRequest request) {
        BusinessSurveyEntity businessSurveyEntity1 = searchService.addSurveyName(businessSurveyEntity);
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
        map = searchService.selectService();
        request.setAttribute("searchMsg", map.get("searchMsg"));
        request.setAttribute("question", map.get("question"));
        request.setAttribute("answer", map.get("answer"));
        return "search";
    }

    @RequestMapping("searchdel")
    public boolean searchDel(int surveyid) {
        return searchService.delSurvey(surveyid);
    }
}

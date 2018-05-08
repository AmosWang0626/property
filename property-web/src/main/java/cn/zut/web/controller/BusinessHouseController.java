package cn.zut.web.controller;

import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("houserent")
public class BusinessHouseController {

    @Resource
    private BusinessHouseService businessHouseService;

    @RequestMapping("houseList")
    @ResponseBody
    public Map<String, Object> houserentList() {
        List<BusinessHouseRentEntity> list = businessHouseService.houseRentList();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("msg", "");
        resultMap.put("code", "0");
        return resultMap;
    }

    @RequestMapping("housedel")
    @ResponseBody
    public boolean houseDel(int id) {
        return businessHouseService.deleteById(id);
    }

    @RequestMapping("housesearch")
    public String houseSearch(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BusinessHouseRentEntity businessHouseRentEntity = businessHouseService.getById(id);
        request.setAttribute("businessHouseRentEntity", businessHouseRentEntity);
        return "detailhouse";
    }

    @RequestMapping("houseadd")
    public String houseAdd(BusinessHouseRentEntity businessHouseRentEntity, HttpServletRequest request) {
        boolean flag = businessHouseService.addHouse(businessHouseRentEntity);
        if (flag) {
            request.setAttribute("houseMsg", "操作成功!");
            return "houseadd";
        }
        return "parameterError";
    }

    @RequestMapping("houseadd1")
    public String houseAdd1(HttpServletRequest request) {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            BusinessHouseRentEntity businessHouseRentEntity = businessHouseService.getById(id);
            request.setAttribute("businessHouseRentEntity", businessHouseRentEntity);
        }
        return "houseadd";
    }
}

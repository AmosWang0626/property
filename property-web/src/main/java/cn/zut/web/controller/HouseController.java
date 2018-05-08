package cn.zut.web.controller;

import cn.zut.core.service.HouseService;
import cn.zut.dao.entity.HouseRentEntity;
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
public class HouseController {

    @Resource
    private HouseService houseService;

    @RequestMapping("houseList")
    @ResponseBody
    public Map<String, Object> houserentList() {
        List<HouseRentEntity> list = houseService.houseRentList();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("msg", "");
        resultMap.put("code", "0");
        return resultMap;
    }

    @RequestMapping("housedel")
    @ResponseBody
    public boolean houseDel(int id) {
        return houseService.deleteById(id);
    }

    @RequestMapping("housesearch")
    public String houseSearch(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        HouseRentEntity houseRentEntity = houseService.getById(id);
        request.setAttribute("houseRentEntity", houseRentEntity);
        return "detailhouse";
    }

    @RequestMapping("houseadd")
    public String houseAdd(HouseRentEntity houseRentEntity, HttpServletRequest request) {
        boolean flag = houseService.addHouse(houseRentEntity);
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
            HouseRentEntity houseRentEntity = houseService.getById(id);
            request.setAttribute("houseRentEntity", houseRentEntity);
        }
        return "houseadd";
    }
}

package cn.zut.web.controller;

import cn.zut.core.service.BusinessCarSetService;
import cn.zut.dao.entity.BusinessCarSetEntity;
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
@RequestMapping("car")
public class BusinessCarController {

    @Resource
    private BusinessCarSetService businessCarSetService;

    @RequestMapping("comeIn")
    public String comeIn(BusinessCarSetEntity businessCarSetEntity, HttpServletRequest request) {
        if (businessCarSetEntity == null || businessCarSetEntity.getCarType() == null) {
            request.setAttribute("businessCarSetEntity", new BusinessCarSetEntity());
            return "carsetadd";
        }
        boolean flag = businessCarSetService.addCarSet(businessCarSetEntity);
        request.setAttribute("carMsg", "添加成功！");
        if (flag) {
            return "carsetadd";
        }
        return "parameterError";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> carList() {
        List<BusinessCarSetEntity> list = businessCarSetService.carList();
        Map<String, Object> resuletMap = new HashMap<>();
        resuletMap.put("data", list);
        resuletMap.put("msg", "");
        resuletMap.put("code", "0");
        return resuletMap;
    }

    @RequestMapping("detail")
    public String carSearch(int id, HttpServletRequest request) {
        BusinessCarSetEntity businessCarSetEntity = businessCarSetService.searchCarSet(id);
        request.setAttribute("businessCarSetEntity", businessCarSetEntity);
        return "carsetdetail";
    }

    @RequestMapping("getRent")
    public String getRent(int id, HttpServletRequest request) {
        BusinessCarSetEntity businessCarSetEntity = businessCarSetService.searchCarSet(id);
        request.setAttribute("businessCarSetEntity", businessCarSetEntity);
        return "getrent";
    }

    @RequestMapping("rentCar")
    public String rentCar(BusinessCarSetEntity businessCarSetEntity, HttpServletRequest request) {
        boolean flag = businessCarSetService.rentCar(businessCarSetEntity);
        if (flag) {
            BusinessCarSetEntity newCarSet = businessCarSetService.searchCarSet(businessCarSetEntity.getId());
            request.setAttribute("carMsg", "操作成功！");
            request.setAttribute("businessCarSetEntity", newCarSet);
            return "getrent";
        }
        return "parameterError";
    }
}

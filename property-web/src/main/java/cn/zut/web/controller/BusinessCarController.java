package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessCarSetService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 主要三个参数
     * 车牌号/车类型/进入时间
     */
    @RequestMapping("comeIn")
    @ResponseBody
    public GenericResponse comeIn(@RequestBody BusinessCarSetEntity businessCarSetEntity) {

        return businessCarSetService.addCarSet(businessCarSetEntity) ? GenericResponse.SUCCESS : GenericResponse.FAIL;
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

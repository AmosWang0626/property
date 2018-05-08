package cn.zut.web.controller;

import cn.zut.core.service.CarSetService;
import cn.zut.dao.entity.CarSetEntity;
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
public class CarController {

    @Resource
    private CarSetService carSetService;

    @RequestMapping("comeIn")
    public String comein(CarSetEntity carSetEntity, HttpServletRequest request) {
        if (carSetEntity == null || carSetEntity.getCartype() == null) {
            request.setAttribute("carSetEntity", new CarSetEntity());
            return "carsetadd";
        }
        boolean flag = carSetService.addCarSet(carSetEntity);
        request.setAttribute("carMsg", "添加成功！");
        if (flag) {
            return "carsetadd";
        }
        return "parameterError";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> carList() {
        List<CarSetEntity> list = carSetService.carList();
        Map<String, Object> resuletMap = new HashMap<>();
        resuletMap.put("data", list);
        resuletMap.put("msg", "");
        resuletMap.put("code", "0");
        return resuletMap;
    }

    @RequestMapping("detail")
    public String carSearch(int id, HttpServletRequest request) {
        CarSetEntity carSetEntity = carSetService.searchCarSet(id);
        request.setAttribute("carSetEntity", carSetEntity);
        return "carsetdetail";
    }

    @RequestMapping("getRent")
    public String getRent(int id, HttpServletRequest request) {
        CarSetEntity carSetEntity = carSetService.searchCarSet(id);
        request.setAttribute("carSetEntity", carSetEntity);
        return "getrent";
    }

    @RequestMapping("rentCar")
    public String rentCar(CarSetEntity carSetEntity, HttpServletRequest request) {
        boolean flag = carSetService.rentCar(carSetEntity);
        if (flag) {
            CarSetEntity newCarSet = carSetService.searchCarSet(carSetEntity.getId());
            request.setAttribute("carMsg", "操作成功！");
            request.setAttribute("carSetEntity", newCarSet);
            return "getrent";
        }
        return "parameterError";
    }
}

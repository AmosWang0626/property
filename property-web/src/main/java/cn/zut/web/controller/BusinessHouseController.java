package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("rent")
public class BusinessHouseController {

    @Resource
    private BusinessHouseService businessHouseService;

    @RequestMapping("add")
    public GenericResponse houseAdd(BusinessHouseRentEntity businessHouseRentEntity) {
        return businessHouseService.addHouse(businessHouseRentEntity);
    }

    @RequestMapping("modify")
    public GenericResponse houseModify(BusinessHouseRentEntity businessHouseRentEntity) {
        if (businessHouseRentEntity.getId() == null) {
            return GenericResponse.ERROR_PARAM;
        }

        return businessHouseService.modifyHouse(businessHouseRentEntity);
    }

    @RequestMapping("search")
    public GenericResponse houseSearch(@RequestParam("id") Integer id) {
        if (id == null) {
            return GenericResponse.ERROR_PARAM;
        }

        return businessHouseService.getById(id);
    }

    @RequestMapping("houseList")
    @ResponseBody
    public GenericResponse houseRentList() {
        return businessHouseService.houseRentList();
    }

    @RequestMapping("delete")
    @ResponseBody
    public GenericResponse houseDel(@RequestParam("id") Integer id) {
        if (id == null) {
            return GenericResponse.ERROR_PARAM;
        }
        return businessHouseService.deleteById(id);
    }
}

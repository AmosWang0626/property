package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.CarBusiness;
import cn.zut.core.business.HouseBusiness;
import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Resource
    private HouseBusiness houseBusiness;

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
    @GetMapping("pagehouse")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<BusinessHouseRentEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(houseBusiness.pageMemberByModel(pageModel));
    }


}

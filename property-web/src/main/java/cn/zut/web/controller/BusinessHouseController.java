package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.HouseBusiness;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("rent")
public class BusinessHouseController {

    @Resource
    private BusinessHouseService businessHouseService;
    @Resource
    private HouseBusiness houseBusiness;

    @RequestMapping("add")
    public GenericResponse houseAdd(@RequestBody BusinessHouseRentEntity businessHouseRentEntity) {
        return businessHouseService.addHouse(businessHouseRentEntity);
    }

    @RequestMapping("modify")
    public GenericResponse houseModify(@RequestBody BusinessHouseRentEntity businessHouseRentEntity) {
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
    public GenericResponse houseRentList() {
        return businessHouseService.houseRentList();
    }

    @RequestMapping("delete")
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
 /*   *//**
     * 修改用户信息
     *//*
    @RequestMapping(value = "modifyUserInfo", method = RequestMethod.POST)
    public GenericResponse modifyUserInfo(@RequestBody @Valid UserInfoRequest userInfoRequest,
                                          BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        if (userInfoRequest.getMemberId() == null) {
            userInfoRequest.setMemberId(getMemberId(request));
        }

        return houseBusiness.modifyUserInfo(userInfoRequest);
    }*/
    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}

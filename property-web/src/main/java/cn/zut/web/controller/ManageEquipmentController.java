package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.EquipmentBusiness;
import cn.zut.core.service.ManageEquipmentService;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.facade.request.EquipmentInfoRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("equipment")
@RestController
public class ManageEquipmentController {

    @Resource
    private EquipmentBusiness equipmentBusiness;

    @Resource
    private ManageEquipmentService manageEquipmentService;

    /*
     *添加企业信息
     */

    @RequestMapping("addEquipment")
    public GenericResponse addEquipment(@RequestBody ManageEquipmentEntity manageEquipmentEntity) {

        return manageEquipmentService.addEquipment(manageEquipmentEntity) ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    /**
     * 修改设备数量
     * @param equipmentInfoRequest
     * @param bindingResult
     * @param request
     * @return
     */
    @RequestMapping(value = "equipmentInfo", method = RequestMethod.POST)
    public GenericResponse modifyUserInfo(@RequestBody @Valid EquipmentInfoRequest equipmentInfoRequest,
                                          BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        if (equipmentInfoRequest.getTypes() == null) {
            return GenericResponse.ERROR_PARAM;
        }

        return equipmentBusiness.equipmentInfo(equipmentInfoRequest);
    }

    /**
     * 删除设备
     */
    @RequestMapping(value = "deleteEquipment", method = RequestMethod.POST)
    public GenericResponse deleteEquipment(@RequestBody @Valid EquipmentInfoRequest equipmentInfoRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return equipmentBusiness.deleteEquipment(equipmentInfoRequest);
    }

    @GetMapping("page")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<ManageEquipmentEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(equipmentBusiness.pageMemberByModel(pageModel));

    }
}

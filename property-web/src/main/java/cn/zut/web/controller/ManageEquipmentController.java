package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.core.business.EquipmentBusiness;
import cn.zut.core.service.ManageEnterpriseService;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.facade.request.EnterpriseInfoRequest;
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

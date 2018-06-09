package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.EquipmentBusiness;
import cn.zut.core.business.LogBusiness;
import cn.zut.core.service.ManageEquipmentService;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.dao.entity.ManageLogEntity;
import cn.zut.facade.request.EquipmentInfoRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("log")
@RestController
public class ManageLogController {


    @Resource
    private ManageEquipmentService manageEquipmentService;

    @Resource
    private LogBusiness logBusiness;
    /*
     *添加
     */

    @RequestMapping("addEquipment")
   /* public GenericResponse addLog(@RequestBody ManageLogEntity manageLogEntity) {

        return manageLogEntity.addLog(manageLogEntity) ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }*/

    @GetMapping("page")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<ManageLogEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(logBusiness.pageMemberByModel(pageModel));
    }
}

package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.core.service.ManageEnterpriseService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.persistence.ManageEnterpriseMapper;
import cn.zut.facade.request.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("enterprise")
@RestController
public class ManageEnterpriseController {

    @Resource
    private EnterpriseBusiness enterpriseBusiness;

    @Resource
    private ManageEnterpriseService manageEnterpriseService;
    /*
     *添加企业信息
     */

    @RequestMapping("addEnterprise")
    public GenericResponse comeIn(@RequestBody ManageEnterpriseEntity manageEnterpriseEntity) {

        return manageEnterpriseService.addEnterprise(manageEnterpriseEntity) ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    /**
     * 修改企业信息
     */
    @RequestMapping(value = "enterpriseInfo", method = RequestMethod.POST)
    public GenericResponse modifyUserInfo(@RequestBody @Valid EnterpriseInfoRequest enterpriseInfoRequest,
                                          BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        if (enterpriseInfoRequest.getName() == null) {
            return GenericResponse.ERROR_PARAM;
        }

        return enterpriseBusiness.enterpriseInfo(enterpriseInfoRequest);
    }

    /**
     * 删除企业
     */
    @RequestMapping(value = "deleteEnterprise", method = RequestMethod.POST)
    public GenericResponse deleteUser(@RequestBody @Valid EnterpriseInfoRequest enterpriseInfoRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return enterpriseBusiness.deleteEnterprise(enterpriseInfoRequest);
    }

    @GetMapping("page")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<ManageEnterpriseEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(enterpriseBusiness.pageMemberByModel(pageModel));

    }
}

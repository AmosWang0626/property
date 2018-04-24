package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import cn.zut.facade.request.TariffBillRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/18
 */
@RestController
@RequestMapping("bill")
public class TariffBillController {

    @Resource
    private TariffBillBusiness tariffBillBusiness;

    @PostMapping("unitPrice")
    public GenericResponse getUnitPrice(@RequestBody @Valid ConsumePreviewRequest consumePreviewRequest,
                                        BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return tariffBillBusiness.getUnitPrice(consumePreviewRequest);
    }

    @RequestMapping("consumeConfirm")
    public GenericResponse consumeConfirm(@RequestBody @Valid ConsumeConfirmRequest consumeConfirmRequest,
                                          BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return tariffBillBusiness.consumeConfirm(getMemberId(request), consumeConfirmRequest);
    }

    @RequestMapping("billEntry")
    public GenericResponse billEntry(@RequestBody @Valid TariffBillRequest tariffBillRequest,
                                     BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return tariffBillBusiness.billEntry(getMemberId(request), tariffBillRequest);
    }

    @GetMapping("pageBill")
    public GenericResponse pageBill(@RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<TariffBillEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(tariffBillBusiness.pageBillByModel(pageModel));
    }

    @GetMapping("pageBillPlan")
    public GenericResponse pageBillPlan(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<TariffBillPlanEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(tariffBillBusiness.pageBillPlanByModel(pageModel));
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}

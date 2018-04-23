package cn.zut.web.controller;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        // 操作人用户编号
        consumeConfirmRequest.setOperatorMemberId(getMemberId(request));
        return tariffBillBusiness.consumeConfirm(consumeConfirmRequest);
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }

}

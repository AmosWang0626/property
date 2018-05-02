package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffPaymentDataBusiness;
import cn.zut.dao.entity.TariffCompanyBillEntity;
import cn.zut.dao.persistence.TariffCompanyBillMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/2
 */
@RestController
@RequestMapping("data")
public class TariffPaymentDataController {

    @Resource
    private TariffPaymentDataBusiness tariffPaymentDataBusiness;

    @GetMapping("pagePaymentRecord")
    public GenericResponse pagePaymentRecord(@RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<TariffCompanyBillEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(tariffPaymentDataBusiness.pagePaymentRecord(pageModel));
    }

}

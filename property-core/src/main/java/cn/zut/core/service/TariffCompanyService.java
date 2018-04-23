package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.facade.request.TariffCompanyBillRequest;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/23
 */
public interface TariffCompanyService {

    /**
     * 记录缴费情况
     *
     * @param tariffCompanyBillRequest 缴费表单
     * @return 缴费状态
     */
    GenericResponse paymentRecord(TariffCompanyBillRequest tariffCompanyBillRequest);
}

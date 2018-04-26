package cn.zut.core.service;

import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;

import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/26
 */
public interface TariffBillService {

    /**
     * 用户还款成功,冲账
     *
     * @param tariffBillEntity     账单实体类
     * @param tariffBillPlanEntity 还款计划实体类
     * @param paymentAmount        支付成功金额
     */
    void billOffset(TariffBillEntity tariffBillEntity, TariffBillPlanEntity tariffBillPlanEntity, BigDecimal paymentAmount);
}

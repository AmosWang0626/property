package cn.zut.facade.request;

import cn.zut.facade.enums.PaymentWayEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/23
 */
@Data
public class TariffCompanyBillRequest {
    /**
     * 公司编号
     */
    private Long companyId;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 缴费计划编号
     */
    private String externalNo;
    /**
     * 交易金额
     */
    private BigDecimal paymentAmount;
    /**
     * 支付方式
     */
    private PaymentWayEnum paymentWay;
}

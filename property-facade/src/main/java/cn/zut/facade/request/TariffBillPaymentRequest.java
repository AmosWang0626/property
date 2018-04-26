package cn.zut.facade.request;

import cn.zut.facade.enums.PaymentWayEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/17
 */
@Data
public class TariffBillPaymentRequest {

    /**
     * 缴费计划编号
     */
    @NotNull(message = "用户支付,参数异常")
    private Long planNo;
    /**
     * 支付金额
     */
    @NotNull(message = "支付金额不能为空")
    private BigDecimal paymentAmount;
    /**
     * 支付状态
     */
    @NotNull(message = "支付方式不能为空")
    private PaymentWayEnum paymentWay;
    /**
     * 还款备注
     */
    private String expand;
}

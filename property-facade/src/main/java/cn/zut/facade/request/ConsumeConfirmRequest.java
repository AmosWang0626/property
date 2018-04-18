package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/17
 */
@Data
public class ConsumeConfirmRequest {

    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
    /**
     * 缴费标准等级
     */
    private BusinessLevelEnum level;
    /**
     * 使用量
     */
    private BigDecimal usedTotal;
    /**
     * 支付状态
     */
    private PaymentStatusEnum paymentStatus;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 消费备注
     */
    private String consumeExpand;
}

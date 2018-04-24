package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentWayEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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
public class ConsumeConfirmRequest {

    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 业务类型
     */
    @NotNull(message = "业务类型不能为空")
    private BusinessTypeEnum business;
    /**
     * 缴费标准等级
     */
    @NotNull(message = "业务等级不能为空")
    private BusinessLevelEnum level;
    /**
     * 使用量
     */
    @NotNull(message = "使用量不能为空")
    private BigDecimal usedTotal;
    /**
     * 支付状态
     */
    @NotNull(message = "支付方式不能为空")
    private PaymentWayEnum paymentWay;
    /**
     * 操作人
     */
    @NotEmpty(message = "操作人不能为空")
    private String operator;
    /**
     * 消费备注
     */
    private String consumeExpand;
}

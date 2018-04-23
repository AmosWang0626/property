package cn.zut.dao.entity;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 即时消费缴费表
 * @date 2018/3/21
 */
@Data
public class TariffConsumeEntity {

    /**
     * 消费编号
     */
    private String consumeNo;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
    /**
     * 缴费标准等级
     */
    private BusinessLevelEnum level;
    /**
     * 资费标准编号
     */
    private Long standardId;
    /**
     * 缴费单价(冗余字段)
     */
    private BigDecimal unitPrice;
    /**
     * 使用量
     */
    private BigDecimal usedTotal;
    /**
     * 消费总金额
     */
    private BigDecimal consumeAmount;
    /**
     * 消费备注
     */
    private String consumeExpand;
    /**
     * 支付状态
     */
    private PaymentStatusEnum paymentStatus;
    /**
     * 拓展字段
     */
    private String expand;
    /**
     * 修改时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date updateTime;
}

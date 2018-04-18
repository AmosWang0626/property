package cn.zut.dao.entity;

import cn.zut.facade.enums.PaymentStatusEnum;
import cn.zut.facade.enums.PaymentWayEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 收费公司账目表
 * @date 2018/3/21
 */
@Data
public class TariffCompanyBillEntity {
    /**
     * 自增id
     */
    private Long id;
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
    private Long externalNo;
    /**
     * 交易金额
     */
    private BigDecimal paymentAmount;
    /**
     * 支付方式
     */
    private PaymentWayEnum paymentWay;
    /**
     * 支付状态
     */
    private PaymentStatusEnum paymentStatus;
    /**
     * 交易时间
     */
    private Date paymentDate;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 创建时间
     */
    private Date createTime;
}

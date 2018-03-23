package cn.zut.dao.entity;

import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentStatusEnum;
import cn.zut.facade.enums.PaymentWayEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 收费公司账目表
 * @date 2018/3/21
 */
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
    private Long planNo;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Long planNo) {
        this.planNo = planNo;
    }

    public BusinessTypeEnum getBusiness() {
        return business;
    }

    public void setBusiness(BusinessTypeEnum business) {
        this.business = business;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentWayEnum getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(PaymentWayEnum paymentWay) {
        this.paymentWay = paymentWay;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

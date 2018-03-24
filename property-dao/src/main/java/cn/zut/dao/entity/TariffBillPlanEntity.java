package cn.zut.dao.entity;

import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.PaymentStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 缴费账单还款计划表
 * @date 2018/3/21
 */
public class TariffBillPlanEntity {
    /**
     * 缴费计划编号
     */
    private Long planNo;
    /**
     * 账单编号
     */
    private Long billNo;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 应还款日期
     */
    private Date repayDate;
    /**
     * 结清日期
     */
    private Date settleDate;
    /**
     * 逾期天数
     */
    private Integer overdueDays;
    /**
     * 支付状态
     */
    private BillStatusEnum billStatus;
    /**
     * 应缴纳本金
     */
    private BigDecimal billAmount;
    /**
     * 应缴纳滞纳金
     */
    private BigDecimal lateChargeAmt;
    /**
     * 已缴纳本金
     */
    private BigDecimal billAmountPaid;
    /**
     * 已缴纳滞纳金
     */
    private BigDecimal lateChargeAmtPaid;
    /**
     * 优惠减免本金
     */
    private BigDecimal billAmountOffer;
    /**
     * 优惠减免滞纳金
     */
    private BigDecimal lateChargeAmtOffer;
    /**
     * 拓展字段
     */
    private String expand;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    public Long getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Long planNo) {
        this.planNo = planNo;
    }

    public Long getBillNo() {
        return billNo;
    }

    public void setBillNo(Long billNo) {
        this.billNo = billNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public BillStatusEnum getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatusEnum billStatus) {
        this.billStatus = billStatus;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getLateChargeAmt() {
        return lateChargeAmt;
    }

    public void setLateChargeAmt(BigDecimal lateChargeAmt) {
        this.lateChargeAmt = lateChargeAmt;
    }

    public BigDecimal getBillAmountPaid() {
        return billAmountPaid;
    }

    public void setBillAmountPaid(BigDecimal billAmountPaid) {
        this.billAmountPaid = billAmountPaid;
    }

    public BigDecimal getLateChargeAmtPaid() {
        return lateChargeAmtPaid;
    }

    public void setLateChargeAmtPaid(BigDecimal lateChargeAmtPaid) {
        this.lateChargeAmtPaid = lateChargeAmtPaid;
    }

    public BigDecimal getBillAmountOffer() {
        return billAmountOffer;
    }

    public void setBillAmountOffer(BigDecimal billAmountOffer) {
        this.billAmountOffer = billAmountOffer;
    }

    public BigDecimal getLateChargeAmtOffer() {
        return lateChargeAmtOffer;
    }

    public void setLateChargeAmtOffer(BigDecimal lateChargeAmtOffer) {
        this.lateChargeAmtOffer = lateChargeAmtOffer;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

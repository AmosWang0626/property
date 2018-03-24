package cn.zut.dao.entity;

import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.PaymentStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 缴费账单表
 * @date 2018/3/21
 */
public class TariffBillEntity {
    /**
     * 账单编号
     */
    private Long billNo;
    /**
     * 户号
     */
    private String houseNo;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
    /**
     * 资费标准编号
     */
    private Long standardId;
    /**
     * 缴费单价(冗余字段)
     */
    private BigDecimal unitPrice;
    /**
     * 逾期利率(冗余字段)
     */
    private BigDecimal overdueRate;
    /**
     * 使用量
     */
    private BigDecimal usedTotal;
    /**
     * 账单金额
     */
    private BigDecimal billAmount;
    /**
     * 账单月份
     */
    private String billMonth;
    /**
     * 支付状态
     */
    private BillStatusEnum billStatus;
    /**
     * 账单起始时间
     */
    private Date billStartDate;
    /**
     * 账单结束时间
     */
    private Date billEndDate;
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

    public Long getBillNo() {
        return billNo;
    }

    public void setBillNo(Long billNo) {
        this.billNo = billNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BusinessTypeEnum getBusiness() {
        return business;
    }

    public void setBusiness(BusinessTypeEnum business) {
        this.business = business;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    public BigDecimal getUsedTotal() {
        return usedTotal;
    }

    public void setUsedTotal(BigDecimal usedTotal) {
        this.usedTotal = usedTotal;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public BillStatusEnum getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatusEnum billStatus) {
        this.billStatus = billStatus;
    }

    public Date getBillStartDate() {
        return billStartDate;
    }

    public void setBillStartDate(Date billStartDate) {
        this.billStartDate = billStartDate;
    }

    public Date getBillEndDate() {
        return billEndDate;
    }

    public void setBillEndDate(Date billEndDate) {
        this.billEndDate = billEndDate;
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

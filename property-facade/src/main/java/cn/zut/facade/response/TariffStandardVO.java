package cn.zut.facade.response;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: TariffStandardVO
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Getter
@Setter
public class TariffStandardVO {
    /**
     * 缴费标准编号
     */
    private Long standardId;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
    /**
     * 缴费标准等级
     */
    private BusinessLevelEnum level;
    /**
     * 缴费单价
     */
    private BigDecimal unitPrice;
    /**
     * 逾期利率
     */
    private BigDecimal overdueRate;
    /**
     * 缴费标准生效时间
     */
    private Date startTime;
    /**
     * 缴费标准失效时间
     */
    private Date endTime;
    /**
     * 状态(1:正常;0:无效)
     */
    private Boolean status;

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public BusinessTypeEnum getBusiness() {
        return business;
    }

    public void setBusiness(BusinessTypeEnum business) {
        this.business = business;
    }

    public BusinessLevelEnum getLevel() {
        return level;
    }

    public void setLevel(BusinessLevelEnum level) {
        this.level = level;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

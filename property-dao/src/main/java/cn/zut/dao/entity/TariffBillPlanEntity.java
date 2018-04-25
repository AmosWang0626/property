package cn.zut.dao.entity;

import cn.zut.facade.enums.BillStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 缴费账单还款计划表
 * @date 2018/3/21
 */
@Data
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

    public BigDecimal getSumBillAmount() {
        return getBillAmount().subtract(getBillAmountPaid()).subtract(getBillAmountOffer());
    }

    public BigDecimal getSumLateCharge() {
        return getLateChargeAmt().subtract(getLateChargeAmtPaid()).subtract(getLateChargeAmtOffer());
    }

    public BigDecimal getTotalRepayAmount() {
        return getSumBillAmount().add(getSumLateCharge());
    }

    public boolean repayFinished() {
        return BigDecimal.ZERO.compareTo(getTotalRepayAmount()) == 0;
    }
}

package cn.zut.facade.response;

import cn.zut.facade.enums.BillStatusEnum;
import lombok.Data;

import java.io.Serializable;
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
public class TariffBillPlanVO implements Serializable {

    private static final long serialVersionUID = -6988649074985162295L;

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
    private BigDecimal sumBillAmount;
    /**
     * 应缴纳罚息
     */
    private BigDecimal sumLateCharge;
    /**
     * 应缴纳总金额
     */
    private BigDecimal totalRepayAmount;
    /**
     * 是否已结清
     */
    private Boolean repayFinished;
}

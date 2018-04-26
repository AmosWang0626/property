package cn.zut.facade.response;

import cn.zut.facade.enums.BillStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/26
 */
@Data
public class TariffBillDetailVO {
    /**
     * 户号
     */
    private String houseNo;
    /**
     * 业务类型
     */
    private String business;
    /**
     * 缴费标准等级
     */
    private String level;
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
    private String billStatus;
}

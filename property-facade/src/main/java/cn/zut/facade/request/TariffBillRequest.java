package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/18
 */
@Data
public class TariffBillRequest {

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
     * 缴费标准等级
     */
    private BusinessLevelEnum level;
    /**
     * 使用量
     */
    private BigDecimal usedTotal;
    /**
     * 拓展字段
     */
    private String expand;
}

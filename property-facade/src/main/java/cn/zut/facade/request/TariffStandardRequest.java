package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Getter
@Setter
public class TariffStandardRequest {
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
}

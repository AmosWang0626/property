package cn.zut.facade.response;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: TariffStandardVO
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Data
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
     * 业务类型 desc
     */
    private String businessDesc;
    /**
     * 缴费标准等级 desc
     */
    private String levelDesc;
    /**
     * 缴费单价
     */
    private BigDecimal unitPrice;
    /**
     * 缴费单价
     */
    private String businessUnit;
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}

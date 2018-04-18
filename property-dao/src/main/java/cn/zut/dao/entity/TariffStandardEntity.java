package cn.zut.dao.entity;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 缴费标准表
 * @date 2018/3/21
 */
@Data
public class TariffStandardEntity {
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}

package cn.zut.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author DaoyuanWang
 * 月度消费
 */
@Data
public class TariffMonthConsumeEntity {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 房屋编号
     */
    private Long houseNo;
    /**
     * 账单月份
     */
    private String month;
    /**
     * 月度用水量
     */
    private BigDecimal water;
    /**
     * 月度用电量
     */
    private BigDecimal electric;
    /**
     * 网络是否开启
     */
    private Boolean network;
    /**
     * 房屋面积
     */
    private BigDecimal property;
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
    private String updateTime;

}
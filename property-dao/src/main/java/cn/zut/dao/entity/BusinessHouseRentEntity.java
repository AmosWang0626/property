package cn.zut.dao.entity;

import cn.zut.facade.enums.HouseRentStatusEnum;
import cn.zut.facade.enums.HouseTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 加上@Data,不用写get set方法,也不用写toString方法
 *
 * @author LiuBowen
 */
@Data
public class BusinessHouseRentEntity {
    /**
     * 房屋编号
     */
    private Integer id;
    /**
     * 房屋名字
     */
    private String name;
    /**
     * 房屋名字
     */
    private String houseNo;
    /**
     * 房屋类型
     */
    private HouseTypeEnum type;
    /**
     * 房屋面积
     */
    private BigDecimal area;
    /**
     * 房屋地址
     */
    private String address;
    /**
     * 房屋租售金额
     */
    private BigDecimal rent;
    /**
     * 房屋详情
     */
    private String details;
    /**
     * 房屋图片
     */
    private String img;
    /**
     * 业主编号
     */
    private Long memberId;
    /**
     * 房屋租售状态
     */
    private HouseRentStatusEnum rentStatus;
    /**
     * 房屋创建时间
     */
    private Date createTime;
    /**
     * 房屋更新时间
     */
    private Date updateTime;

}
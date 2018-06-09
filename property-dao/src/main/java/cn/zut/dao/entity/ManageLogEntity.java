package cn.zut.dao.entity;


import lombok.Data;

import java.util.Date;

@Data
public class ManageLogEntity {

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 用户编号
     */
    private Long memberId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 操作描述
     */
    private String operate;
    /**
     * 执行时间
     */
    private Date operateTime;

}
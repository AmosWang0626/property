package cn.zut.dao.entity;


import lombok.Data;

import java.util.Date;

@Data
public class ManageEnterpriseEntity {


    private Long id;
    /**
     * 公司名称
     */
    private String enterpriseName;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司联系方式
     */
    private String phone;
    /**
     * 企业法人名字
     */
    private String leaderName;
    /**
     * 创建时间
     */
    private Date settledTime;
}




package cn.zut.dao.entity;


import lombok.Data;

import java.util.Date;

@Data
public class ManageEquipmentEntity {


    private Long id;
    /**
     * 设备类型
     */
    private String types;
    /**
     * 设备名称
     */
    private String amount;
}




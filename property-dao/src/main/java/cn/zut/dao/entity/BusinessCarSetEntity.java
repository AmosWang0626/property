package cn.zut.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BusinessCarSetEntity {

    private Integer id;

    private Date comeDate;

    private Date leaveDate;

    private String carType;

    private String carNo;

    private BigDecimal rent;
}
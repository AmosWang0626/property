package cn.zut.dao.entity;

import cn.zut.common.enums.GenderEnum;
import cn.zut.common.enums.MaritalEnum;
import lombok.Data;

import java.util.Date;

/**
 * PROJECT: property
 * DATE: 2017/11/20
 *
 * @author DaoyuanWang
 */
@Data
public class MemberEntity {

    /**
     * 会员编号
     */
    private Long memberId;
    /**
     * 电话号码
     */
    private String phoneNo;
    /**
     * 客户昵称
     */
    private String nickName;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 客户姓名
     */
    private String realName;
    /**
     * 客户性别
     */
    private GenderEnum gender;
    /**
     * 客户年龄
     */
    private Integer age;
    /**
     * 客户婚姻状况
     */
    private MaritalEnum maritalStatus;
    /**
     * 用户权限编号
     */
    private Integer rolesId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public void init() {
        Date date = new Date();
        this.setCreateTime(date);
        this.setUpdateTime(date);
        this.setMaritalStatus(MaritalEnum.NONE);
    }
}
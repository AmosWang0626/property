package cn.zut.dao.entity;

import cn.zut.common.enums.GenderEnum;
import cn.zut.common.enums.MaritalEnum;

import java.util.Date;

/**
 * PROJECT: catherine
 * DATE: 2017/11/20
 *
 * @author DaoyuanWang
 */
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public MemberEntity() {
    }

    public void init() {
        Date date = new Date();
        this.setCreateTime(date);
        this.setUpdateTime(date);
        this.setMaritalStatus(MaritalEnum.NONE);
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MaritalEnum getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalEnum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

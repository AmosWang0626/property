package cn.zut.facade.request;

import cn.zut.common.enums.GenderEnum;
import cn.zut.common.enums.MaritalEnum;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class UserInfoRequest {

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @NotBlank(message = "手机号不能为空")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @NotBlank(message = "昵称不能为空")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
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
}

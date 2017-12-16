package cn.zut.dao.entity;

import java.util.Date;

/**
 * 登录信息表
 * DATE: 2017/7/25
 * PROJECT: property
 *
 * @author DaoyuanWang
 */
public class LoginInfoEntity {

    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 密码盐
     */
    private String salt;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 连续输错密码次数
     */
    private Integer errorCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上一次登陆成功时间
     */
    private Date lastLoginTime;

    public LoginInfoEntity() {
    }

    public void init() {
        Date date = new Date();
        this.setCreateTime(date);
        this.setLastLoginTime(date);
        this.setErrorCount(1);
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}

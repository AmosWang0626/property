package cn.zut.facade.request;

import java.io.Serializable;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public class RegisterForm implements Serializable {

    private static final long serialVersionUID = -5267379236272654682L;

    /**
     * 电话号码
     */
    private String phoneNo;
    /**
     * 客户昵称
     */
    private String nickName;
    /**
     * 账户密码
     */
    private String password;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

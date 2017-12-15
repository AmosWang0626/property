package cn.zut.facade.request;

import java.io.Serializable;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
public class LoginForm implements Serializable {

    private static final long serialVersionUID = 7216448534738010087L;

    /**
     * 电话号码
     */
    private String phoneNo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

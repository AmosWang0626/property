package cn.zut.facade.request;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @author DaoyuanWang
 */
public class ForgetPwdForm implements Serializable {

    private static final long serialVersionUID = 8641123130791370695L;

    /**
     * 用户名
     */
    private String name;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户密码
     */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

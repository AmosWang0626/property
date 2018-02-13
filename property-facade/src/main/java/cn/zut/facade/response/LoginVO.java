package cn.zut.facade.response;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
public class LoginVO implements Serializable {

    private static final long serialVersionUID = -6749729373040718898L;

    /**
     * 用户token
     */
    private String token;
    /**
     * 加密后的电话号码
     */
    private String phoneNo;
    /**
     * 客户昵称
     */
    private String nickName;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

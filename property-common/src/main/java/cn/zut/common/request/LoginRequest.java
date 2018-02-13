package cn.zut.common.request;

import com.google.gson.Gson;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class LoginRequest {

    private String phoneLogin;
    private String pwdLogin;

    @NotBlank(message = "手机号不能为空")
    public String getPhoneLogin() {
        return phoneLogin;
    }

    public void setPhoneLogin(String phoneLogin) {
        this.phoneLogin = phoneLogin;
    }

    public String getPwdLogin() {
        return pwdLogin;
    }

    @NotBlank(message = "密码不能为空")
    public void setPwdLogin(String pwdLogin) {
        this.pwdLogin = pwdLogin;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

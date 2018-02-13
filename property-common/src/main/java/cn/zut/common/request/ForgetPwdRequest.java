package cn.zut.common.request;

import com.google.gson.Gson;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class ForgetPwdRequest {

    private String nameForgetPwd;
    private String phoneForgetPwd;
    private String pwdForgetPwd;

    @NotBlank(message = "昵称不能为空")
    public String getNameForgetPwd() {
        return nameForgetPwd;
    }

    public void setNameForgetPwd(String nameForgetPwd) {
        this.nameForgetPwd = nameForgetPwd;
    }

    @NotBlank(message = "手机号不能为空")
    public String getPhoneForgetPwd() {
        return phoneForgetPwd;
    }

    public void setPhoneForgetPwd(String phoneForgetPwd) {
        this.phoneForgetPwd = phoneForgetPwd;
    }

    @NotBlank(message = "密码不能为空")
    public String getPwdForgetPwd() {
        return pwdForgetPwd;
    }

    public void setPwdForgetPwd(String pwdForgetPwd) {
        this.pwdForgetPwd = pwdForgetPwd;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

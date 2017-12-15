package cn.zut.web.request;

import com.google.gson.Gson;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class RegisterRequest {

    private String nameRegister;
    private String phoneRegister;
    private String pwdRegister;

    @NotBlank(message = "昵称不能为空")
    public String getNameRegister() {
        return nameRegister;
    }

    public void setNameRegister(String nameRegister) {
        this.nameRegister = nameRegister;
    }

    @NotBlank(message = "手机号不能为空")
    public String getPhoneRegister() {
        return phoneRegister;
    }

    public void setPhoneRegister(String phoneRegister) {
        this.phoneRegister = phoneRegister;
    }

    @NotBlank(message = "密码不能为空")
    public String getPwdRegister() {
        return pwdRegister;
    }

    public void setPwdRegister(String pwdRegister) {
        this.pwdRegister = pwdRegister;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

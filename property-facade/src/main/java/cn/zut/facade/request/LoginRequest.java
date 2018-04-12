package cn.zut.facade.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class LoginRequest {

    /**
     * 手机号
     */
    private String phoneNo;
    /**
     * 新密码
     */
    private String password;

    @NotBlank(message = "手机号不能为空")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @NotBlank(message = "密码不能为空")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

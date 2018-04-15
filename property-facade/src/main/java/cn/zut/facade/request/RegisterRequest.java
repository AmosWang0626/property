package cn.zut.facade.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class RegisterRequest {

    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phoneNo;
    /**
     * 短信验证码
     */
    private String verifyCode;
    /**
     * 密码
     */
    private String password;

    @NotBlank(message = "昵称不能为空")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @NotBlank(message = "手机号不能为空")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @NotBlank(message = "验证码不能为空")
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @NotBlank(message = "密码不能为空")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

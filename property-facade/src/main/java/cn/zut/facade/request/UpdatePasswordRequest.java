package cn.zut.facade.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author DaoyuanWang
 */
public class UpdatePasswordRequest {

    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 确认新密码
     */
    private String confirmPassword;

    @NotBlank(message = "旧密码不能为空")
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @NotBlank(message = "新密码不能为空")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @NotBlank(message = "确认新密码不能为空")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

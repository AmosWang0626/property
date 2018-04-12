package cn.zut.common.util;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
public class EncryptUtil {

    /**
     * 默认短信验证码
     */
    private static final String VERIFY_CODE = "666666";

    /**
     * 手机号加密
     *
     * @param phoneNo 手机号
     * @return 加密后的手机号
     */
    public static String encryptPhoneNo(String phoneNo) {
        return phoneNo.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 检验短信验证码
     *
     * @param verifyCode 短信验证码
     * @return 验证码正确: true;
     */
    public static boolean checkVerifyCode(String verifyCode) {
        return VERIFY_CODE.equals(verifyCode);
    }
}

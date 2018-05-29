package cn.zut.core.constant;

/**
 * PROJECT: property
 * DATE: 2017/12/11
 *
 * @author DaoYuanWang
 */
public interface PropertyConstant {
    /**
     * 随机字符串
     */
    String DES_PASSWORD = "VBC546QP";
    /**
     * 密码盐长度
     */
    Integer SALT_LENGTH = 8;
    /**
     * Token
     */
    String TOKEN_ENCRYPT = "cityGRIh6752";
    /**
     * memberId -- 用户编号
     */
    String MEMBER_ID = "memberId";
    /**
     * Header -- 用户登录令牌
     */
    String TOKEN = "token";
    /**
     * Header -- 用户权限id
     */
    String ROLES_ID = "rolesId";
    /**
     * Header -- 用户设备编号
     */
    String DEVICE_ID = "deviceId";

    /**
     * 左右
     */
    String LEFT = "left";
    String RIGHT = "right";
}

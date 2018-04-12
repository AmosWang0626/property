package cn.zut.facade.response;

import lombok.Data;

import java.io.Serializable;

/**
 * PROJECT: property
 *
 * @author DaoyuanWang
 * @date 2018/3/9
 * @apiNote 登录信息VO
 */
@Data
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -3216712463111859678L;

    /**
     * 用户token
     */
    private String token;
    /**
     * 加密后的电话号码
     */
    private String phoneNo;
    /**
     * 用户昵称
     */
    private String nickName;
}

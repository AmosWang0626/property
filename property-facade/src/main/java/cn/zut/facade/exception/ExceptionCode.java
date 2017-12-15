package cn.zut.facade.exception;

import cn.zut.common.response.Message;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public enum ExceptionCode implements Message {
    /**
     * Exception Code And Exception Msg
     */
    PARAM_ERROR("M2000", "参数异常[{}]"),
    PHONE_IS_EXIST("M2001", "该手机号已注册[{}]"),
    PHONE_NO_ERROR("M2002", "手机号格式错误[{}]"),
    PHONE_IS_NOT_EXIST("M2003", "手机号还未注册[{}]"),
    MEMBER_DATA_EXCEPTION("M2004", "手机号还未注册[{}]"),
    MEMBER_PASSWORD_ERROR("M2005", "密码错误"),
    NICK_NAME_PHONE_NOT_NULL("M2006", "昵称和手机号不匹配"),
    ;

    private final String respCode;
    private final String respMsg;

    ExceptionCode(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    @Override
    public String getRespCode() {
        return this.respCode;
    }

    @Override
    public String getRespMsg() {
        return this.respMsg;
    }
}

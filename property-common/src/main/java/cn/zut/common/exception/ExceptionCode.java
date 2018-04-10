package cn.zut.common.exception;

import cn.zut.common.generic.Message;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public enum ExceptionCode implements Message {
    /**
     * Exception Code And Exception Msg
     * 注意: 往错误码中追加参数,一定要加{0...}
     */
    PARAM_ERROR("M2000", "参数异常[{0}]"),
    PHONE_IS_EXIST("M2001", "该手机号已注册[{0}]"),
    PHONE_NO_ERROR("M2002", "手机号格式错误[{0}]"),
    PHONE_IS_NOT_EXIST("M2003", "手机号还未注册[{0}]"),
    MEMBER_DATA_EXCEPTION("M2004", "用户登录信息异常[{0}]"),
    MEMBER_PASSWORD_ERROR("M2005", "您输入的密码错误"),
    NICK_NAME_PHONE_NOT_NULL("M2006", "昵称和手机号不匹配"),
    PLEASE_INPUT_PHONE_NO("M2007", "请输入手机号"),
    PLEASE_INPUT_PHONE_NO_AND_PASSWORD("M2008", "请输入手机号和密码"),
    UPLOAD_FILE_IS_NULL("M2009", "上传的文件不能为空"),
    LAST_DATE_NOT_SMALL_PRE_DATE("M2010", "结束日期不能大于开始日期"),
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

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
    UNKNOWN_EXCEPTION("S0001", "未知异常"),
    PARAM_ERROR("S0002", "参数异常[{0}]"),

    PHONE_IS_EXIST("M2001", "该手机号已注册[{0}]"),
    PHONE_NO_ERROR("M2002", "手机号格式错误[{0}]"),
    PHONE_IS_NOT_EXIST("M2003", "手机号还未注册[{0}]"),
    MEMBER_DATA_EXCEPTION("M2004", "用户登录信息异常[{0}]"),
    MEMBER_PASSWORD_ERROR("M2005", "您输入的密码错误"),
    PLEASE_INPUT_PROPER_VERIFY_CODE("M2006", "您输入的验证码有误,请重试"),
    PLEASE_INPUT_PHONE_NO("M2007", "请输入手机号"),
    PLEASE_INPUT_PHONE_NO_AND_PASSWORD("M2008", "请输入手机号和密码"),
    UPLOAD_FILE_IS_NULL("M2009", "上传的文件不能为空"),
    LAST_DATE_NOT_SMALL_PRE_DATE("M2010", "结束日期不能大于开始日期"),

    TARIFF_STANDARD_IS_EXIST("T0002", "当前资费标准已存在,可删除,可修改"),
    TARIFF_STANDARD_IS_NOT_EXIST("T0001", "当前资费标准不存在,请联系管理员添加"),

    /**
     * 交易失败原因
     */
    PAYMENT_WAY_NOT_EXIST("TP0001", "请先选择支付方式"),
    PAYMENT_ALI_PAY_PWD_ERROR("TP0001", "[支付宝支付]交易失败, 失败原因[密码错误]"),
    PAYMENT_ALI_PAY_INSUFFICIENT_BALANCE("TP0001", "[支付宝支付]交易失败, 失败原因[余额不足]"),
    PAYMENT_ALI_PAY_NETWORK_ERROR("TP0001", "[支付宝支付]交易失败, 失败原因[网络异常]"),
    PAYMENT_ALI_PAY_OVER_QUOTA("TP0001", "[支付宝支付]交易失败, 失败原因[超过限额]"),
    PAYMENT_WE_CHAT_PWD_ERROR("TP0001", "[微信支付]交易失败, 失败原因[密码错误]"),
    PAYMENT_WE_CHAT_INSUFFICIENT_BALANCE("TP0001", "[微信支付]交易失败, 失败原因[余额不足]"),
    PAYMENT_WE_CHAT_NETWORK_ERROR("TP0001", "[微信支付]交易失败, 失败原因[网络异常]"),
    PAYMENT_WE_CHAT_OVER_QUOTA("TP0001", "[微信支付]交易失败, 失败原因[超过限额]"),
    PAYMENT_BANK_CARD_PWD_ERROR("TP0001", "[银行卡支付]交易失败, 失败原因[密码错误]"),
    PAYMENT_BANK_CARD_INSUFFICIENT_BALANCE("TP0001", "[银行卡支付]交易失败, 失败原因[余额不足]"),
    PAYMENT_BANK_CARD_OVER_QUOTA("TP0001", "[银行卡支付]交易失败, 失败原因[超过限额]"),
    PAYMENT_CASH_COUNTERFEIT_MONEY("TP0001", "[现金支付]交易失败, 失败原因[假币]"),
    PAYMENT_CASH_NOTCH("TP0001", "[现金支付]交易失败, 失败原因[缺角]"),

    DEMO("0", "666"),;

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

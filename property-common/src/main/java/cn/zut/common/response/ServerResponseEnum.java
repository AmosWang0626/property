package cn.zut.common.response;

/**
 * PROJECT: property
 * DATE: 2017/11/19
 *
 * @author DaoyuanWang
 */
public enum ServerResponseEnum implements Message {

    /**
     * 系统级别响应
     */
    SUCCESS("1000", "成功"),
    FAIL("1001", "失败"),
    ERROR_PARAM("1002", "传入参数校验失败"),
    ILLEGAL_REQUEST("1003", "非法请求"),
    SERVER_EXCEPTION("1004", "服务器异常");

    ServerResponseEnum(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    private final String respCode;
    private final String respMsg;

    @Override
    public String getRespCode() {
        return this.respCode;
    }

    @Override
    public String getRespMsg() {
        return this.respMsg;
    }
}

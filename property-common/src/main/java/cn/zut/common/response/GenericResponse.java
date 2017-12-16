package cn.zut.common.response;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * PROJECT: property
 * DATE: 2017/11/19
 *
 * @author DaoyuanWang
 */
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 5062883636135185832L;

    /**
     * 通用业务返回对象模型常量,body 都为null.
     */
    public static final GenericResponse SUCCESS = new GenericResponse(ServerResponseEnum.SUCCESS);
    public static final GenericResponse FAIL = new GenericResponse(ServerResponseEnum.FAIL);
    public static final GenericResponse ERROR_PARAM = new GenericResponse(ServerResponseEnum.ERROR_PARAM);
    public static final GenericResponse ILLEGAL_REQUEST = new GenericResponse(ServerResponseEnum.ILLEGAL_REQUEST);
    public static final GenericResponse SERVER_EXCEPTION = new GenericResponse(ServerResponseEnum.SERVER_EXCEPTION);

    /**
     * 响应码
     */
    private String respCode;
    /**
     * 响应信息
     */
    private String respMsg;

    /**
     * 业务对象
     */
    private T body;

    /**
     * 默认无参构造方法
     */
    protected GenericResponse() {
    }

    /**
     * 使用业务对象T body构造的GenericResponse实例.
     * 其中默认使用{@link ServerResponseEnum#SUCCESS}对象设置respCode,respMsg属性.
     *
     * @param body 业务对象.
     */
    public GenericResponse(T body) {
        this(ServerResponseEnum.SUCCESS, body);
    }

    /**
     * 使用{@link Message}对象构造的GenericResponse实例.
     * 其中属性body的值null.
     * 业务系统应定义一个enum类型的类实现{@link Message}接口.
     *
     * @param message 定义过的提示对象.
     */
    public GenericResponse(Message message) {
        this(message.getRespCode(), message.getRespMsg(), null);
    }

    /**
     * 使用{@link Message}对象和业务对象T body构造的GenericResponse实例.
     *
     * @param message 定义过的提示对象.
     * @param body    业务对象.
     */
    public GenericResponse(Message message, T body) {
        this(message.getRespCode(), message.getRespMsg(), body);
    }

    public GenericResponse(String respCode, String respMsg, T body) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.body = body;
    }

    /**
     * 该方法用于追加属性respMsg的值.
     * 支持链式访问.
     *
     * @param args 参数
     * @return this
     */
    public GenericResponse<T> appendRespMsg(Object... args) {
        return setRespMsg(getRespMsg() + Arrays.asList(args));
    }

    /**
     * 使用MessageFormat格式化respMsg中的点位符.
     * 支持链式访问.
     *
     * @param args 参数
     * @return this
     */
    public GenericResponse<T> formatRespMsg(Object... args) {
        checkGlobalResponse();
        return setRespMsg(MessageFormat.format(getRespMsg(), args));
    }

    /**
     * 服务端提示不能修改其内容.
     */
    private void checkGlobalResponse() {
        if (isServerResponse()) {
            throw new IllegalArgumentException("You can't change the respMsg of server response!");
        }
    }

    /**
     * 响应是否成功
     *
     * @return true:成功;false:失败.
     */
    public boolean success() {
        return SUCCESS.getRespCode().equals(getRespCode());
    }

    /**
     * 判断是不是服务端提示,子类可根据需求重写此方法.
     */
    protected boolean isServerResponse() {
        return this == SUCCESS || this == FAIL || this == ERROR_PARAM || this == ILLEGAL_REQUEST || this == SERVER_EXCEPTION;
    }

    public String getRespCode() {
        return respCode;
    }

    public GenericResponse<T> setRespCode(String respCode) {
        this.respCode = respCode;
        return this;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public GenericResponse<T> setRespMsg(String respMsg) {
        this.respMsg = respMsg;
        return this;
    }

    public T getBody() {
        return body;
    }

    public GenericResponse<T> setBody(T body) {
        this.body = body;
        return this;
    }
}

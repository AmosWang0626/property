package cn.zut.common.response;

import java.io.Serializable;

/**
 * 通用业务消息接口，
 * 各业务系统应定义一个枚举类实现该接口。
 * 约定：response code 以"1"开头的为系统级别的消息。
 * 各业务系统实现此接口时，不能使用以"1" 开头的respCode。
 * PROJECT: property
 * DATE: 2017/11/19
 *
 * @author DaoyuanWang
 */
public interface Message extends Serializable {

    /**
     * 实现此方法务必设置响应码
     *
     * @return 响应码
     */
    String getRespCode();

    /**
     * 实现此方法务必设置响应信息
     *
     * @return 响应信息
     */
    String getRespMsg();
}

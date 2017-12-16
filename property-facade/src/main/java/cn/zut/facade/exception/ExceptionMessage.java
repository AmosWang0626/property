package cn.zut.facade.exception;

import cn.zut.common.response.Message;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public class ExceptionMessage implements Message {

    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    private Message message;

    private Object[] parameters;

    public ExceptionMessage(Message message, Object... parameters) {
        this.message = message;
        this.parameters = parameters;
    }

    @Override
    public String getRespCode() {
        return message.getRespCode();
    }

    @Override
    public String getRespMsg() {
        if (ArrayUtils.isEmpty(parameters)) {
            return message.getRespMsg();
        } else {
            Object[] formatParameters = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Object object = parameters[i];
                if (object instanceof BigDecimal) {
                    // 设为false不使用分组方式显示数据; 例如:99999 9,9999
                    NUMBER_FORMAT.setGroupingUsed(false);
                    formatParameters[i] = NUMBER_FORMAT.format(object);
                } else if (object instanceof Long) {
                    formatParameters[i] = String.valueOf(object);
                } else {
                    formatParameters[i] = object;
                }
            }
            return MessageFormat.format(message.getRespMsg(), formatParameters);
        }
    }
}

package cn.zut.facade.enums;

import cn.zut.facade.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum PaymentStatusEnum implements Mapping {

    /**
     * 支付状态
     */
    PAY_SUCCESS("支付成功"),
    PAY_FAIL("支付失败"),
    PAY_PROCESSING("支付处理中");

    private final String value;

    PaymentStatusEnum(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return value;
    }

    /**
     * 传入字符串返回匹配枚举, 使用者要对null进行处理
     *
     * @param value 字符串key
     * @return this
     */
    public PaymentStatusEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (PaymentStatusEnum paymentStatusEnum : PaymentStatusEnum.values()) {
            if (paymentStatusEnum.getKey().equals(value)) {
                return paymentStatusEnum;
            }
        }
        return null;
    }
}

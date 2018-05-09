package cn.zut.facade.enums;

import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum BusinessTypeEnum implements Mapping<String, String> {

    /**
     * 支付方式
     */
    WATER("水费"),
    ELECTRICITY("电费"),
    NETWORK("网费"),
    SITE("场地使用费"),
    PARKING("停车费"),
    PROPERTY("物业费"),;

    private final String value;

    BusinessTypeEnum(String value) {
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
    public BusinessTypeEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (BusinessTypeEnum businessTypeEnum : BusinessTypeEnum.values()) {
            if (businessTypeEnum.getKey().equals(value)) {
                return businessTypeEnum;
            }
        }
        return null;
    }
}

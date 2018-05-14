package cn.zut.facade.enums;

import cn.zut.common.api.ComboVO;
import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum BusinessUnitEnum implements Mapping<String, String> {

    /**
     * 标准单位
     */
    UNIT_PROPERTY("元/月.平方米"),
    UNIT_SITE("元/小时"),
    UNIT_WATER("元/立方米"),
    UNIT_ELECTRICITY("元/度"),
    UNIT_NETWORK("元/月"),
    UNIT_PARKING("元/小时"),;

    private final String value;

    BusinessUnitEnum(String value) {
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
    public BusinessUnitEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (BusinessUnitEnum businessLevelEnum : BusinessUnitEnum.values()) {
            if (businessLevelEnum.getKey().equals(value)) {
                return businessLevelEnum;
            }
        }
        return null;
    }

    public static ComboVO getComboVO(BusinessUnitEnum businessLevelEnum) {
        return new ComboVO<>(businessLevelEnum.getKey(), businessLevelEnum.getValue());
    }
}

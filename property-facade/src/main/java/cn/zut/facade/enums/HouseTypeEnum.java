package cn.zut.facade.enums;

import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 * 房屋租售状态
 *
 * @author DaoYuanWang
 */
public enum HouseTypeEnum implements Mapping<String, String> {

    /**
     * 此状态可出租
     */
    HOUSE("住宅"),
    /**
     * 已租出,不允许再次出租
     */
    OFFICE("办公室"),
    /**
     * 此状态时,不允许操作
     */
    OTHER("其他"),;

    private final String value;

    HouseTypeEnum(String value) {
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
    public HouseTypeEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (HouseTypeEnum billStatusEnum : HouseTypeEnum.values()) {
            if (billStatusEnum.getKey().equals(value)) {
                return billStatusEnum;
            }
        }
        return null;
    }
}

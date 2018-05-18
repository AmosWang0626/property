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
public enum HouseRentStatusEnum implements Mapping<String, String> {

    /**
     * 此状态可出租
     */
    UN_RENT("未租出"),
    /**
     * 已租出,不允许再次出租
     */
    RENT_ED("已租出"),
    /**
     * 此状态时,不允许操作
     */
    RENT_ING("租售中"),
    /**
     * 此状态时,不允许操作,认为该房屋已租给别人,
     * 含这个状态的整条数据失效,也就是终态
     * （刚开始房屋租给A，后来A到期，A走了，房屋给了B，那么租给A的这条记录失效，终态）
     */
    RENT_INVALID("房屋租售失效"),;

    private final String value;

    HouseRentStatusEnum(String value) {
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
    public HouseRentStatusEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (HouseRentStatusEnum billStatusEnum : HouseRentStatusEnum.values()) {
            if (billStatusEnum.getKey().equals(value)) {
                return billStatusEnum;
            }
        }
        return null;
    }
}

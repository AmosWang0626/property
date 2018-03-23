package cn.zut.facade.enums;

import cn.zut.facade.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum BillStatusEnum implements Mapping {

    /**
     * 账单状态
     */
    REPAYING("待还款"),
    OVERDUE("逾期中"),
    SETTLE("已结清");

    private final String value;

    BillStatusEnum(String value) {
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
    public BillStatusEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (BillStatusEnum billStatusEnum : BillStatusEnum.values()) {
            if (billStatusEnum.getKey().equals(value)) {
                return billStatusEnum;
            }
        }
        return null;
    }
}

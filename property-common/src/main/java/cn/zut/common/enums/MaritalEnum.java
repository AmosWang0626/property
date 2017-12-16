package cn.zut.common.enums;

/**
 * PROJECT: property
 * DATE: 2017/11/20
 *
 * @author DaoYuanWang
 */
public enum MaritalEnum implements IEnum {
    /**
     * 婚姻枚举
     */
    NONE("未填写"),
    UNMARRIED("未婚"),
    MARRIED("已婚"),
    DIVORCED("离异"),
    WIDOWED("丧偶"),;

    private final String value;

    MaritalEnum(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return this.value;
    }
}

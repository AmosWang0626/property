package cn.zut.common.enums;

/**
 * 职位枚举类
 */
public enum PositionEnum implements IEnum {
    /**
     * 职位
     */
    ADVANCED_MANAGE("高层管理者"),
    INTERMEDIATE_MANAGE("中层管理"),
    GENERAL_STAFF("普通员工"),;

    private final String value;

    PositionEnum(String value) {
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

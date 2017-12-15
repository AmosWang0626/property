package cn.zut.common.enums;

/**
 * PROJECT: catherine
 * DATE: 2017/11/20
 *
 * @author DaoYuanWang
 */
public enum GenderEnum implements IEnum {
    /**
     * 性别枚举
     */
    MAN("男"),
    WOMAN("女"),;

    private final String value;

    GenderEnum(String value) {
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

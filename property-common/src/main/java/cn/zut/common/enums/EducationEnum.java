package cn.zut.common.enums;

/**
 * PROJECT: property
 * DATE: 2017/11/20
 *
 * @author DaoYuanWang
 */
public enum EducationEnum implements IEnum {
    /**
     * 学历
     */
    PRIMARY_SCHOOL("小学及以下"),
    SECONDARY_SCHOOL("中学"),
    SPECIALIST("专科"),
    UNDERGRADUATE("本科"),
    MASTER_DEGREE("硕士"),
    DOCTOR("博士及以上"),;

    private final String value;

    EducationEnum(String value) {
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

package cn.zut.common.enums;

/**
 * 银行缩写 && 中文
 */
public enum BankEnum implements IEnum {
    /**
     * 缩写 && 中文
     */
    ICBC("中国工商银行"),
    BOC("中国银行"),
    CCB("中国建设银行"),
    PSBC("中国邮政储蓄银行"),
    ECITIC("中信银行"),
    CEB("光大银行"),
    CIB("兴业银行"),
    SPDB("上海浦东发展银行"),
    SZPA("平安银行"),
    CMBC("民生银行"),
    GDB("广发银行"),
    BCCB("北京银行"),
    ABC("中国农业银行"),
    CMB("招商银行"),
    BCM("交通银行");

    private final String name;

    BankEnum(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return this.name;
    }
}

package cn.zut.facade.enums;

import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * 服务申请类型
 *
 * @author LiuBowen
 */
public enum ServiceTypeEnum implements Mapping<String, String> {

    /**
     * 报修|举报|其他
     */
    BAO_XIU("报修"),
    JU_BAO("举报"),
    OTHERS("其他");

    private final String value;

    ServiceTypeEnum(String value) {
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
    public ServiceTypeEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (ServiceTypeEnum serviceTypeEnum : ServiceTypeEnum.values()) {
            if (serviceTypeEnum.getKey().equals(value)) {
                return serviceTypeEnum;
            }
        }
        return null;
    }

}

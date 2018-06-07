package cn.zut.facade.enums;

import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

public enum  ServiceSatus implements Mapping<String, String> {

    /**
     * 服务状态
     */
    IN_APPLY("申请中"),
    IN_ACCEPT("受理中"),
    NO_CONSENT("不同意处理"),
    CONSENT("同意处理"),
    IN_DEAL("处理中"),
    OVER("完成");

    private final String value;

    ServiceSatus(String value) {
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
    public ServiceSatus values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (ServiceSatus serviceSatus : ServiceSatus.values()) {
            if (serviceSatus.getKey().equals(value)) {
                return serviceSatus;
            }
        }
        return null;
    }


}

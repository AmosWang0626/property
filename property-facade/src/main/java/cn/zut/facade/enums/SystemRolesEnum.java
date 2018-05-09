package cn.zut.facade.enums;

import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

/**
 * PROJECT: property2
 * DESCRIPTION: 系统用户枚举
 *
 * @author DaoYuanWang
 * @date 2018/5/9
 */
public enum SystemRolesEnum implements Mapping {
    /**
     * 系统用户
     */
    USER(1, "用户"),
    OWNER(2, "业主"),
    WORKER(3, "员工"),
    MANAGER(4, "主管"),
    ADMIN(5, "管理员"),;

    private final Integer index;
    private final String value;

    SystemRolesEnum(Integer index, String value) {
        this.index = index;
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

    public Integer getIndex() {
        return index;
    }

    /**
     * 传入字符串返回匹配枚举, 使用者要对null进行处理
     *
     * @param value 字符串key
     * @return this
     */
    public SystemRolesEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (SystemRolesEnum baseEnum : SystemRolesEnum.values()) {
            if (baseEnum.getKey().equals(value)) {
                return baseEnum;
            }
        }
        return null;
    }

}

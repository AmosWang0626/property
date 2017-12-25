package cn.zut.common.to;

import java.io.Serializable;

/**
 * PROJECT: property
 * DATE: 2017/12/14
 *
 * @author DaoYuanWang
 */
public class CardWarnDTO implements Serializable {

    private static final long serialVersionUID = 4112386627056371145L;

    /**
     * 错误信息
     */
    private String errorCodes;
    /**
     * 错误类型
     */
    private String name;

    public String getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(String errorCodes) {
        this.errorCodes = errorCodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

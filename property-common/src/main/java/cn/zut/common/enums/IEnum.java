package cn.zut.common.enums;

/**
 * PROJECT: catherine
 * DATE: 2017/11/20
 *
 * @author DaoYuanWang
 */
public interface IEnum {

    // MY_ENUM("枚举备注");

    /**
     * 枚举名称.
     *
     * @return MY_ENUM [注:this.name()];
     */
    String getKey();

    /**
     * 枚举内容.
     *
     * @return 枚举备注;
     */
    String getValue();
}

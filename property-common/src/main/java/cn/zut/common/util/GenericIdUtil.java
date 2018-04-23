package cn.zut.common.util;

import java.util.Date;

/**
 * PROJECT: property
 * DATE: 2017/11/20
 *
 * @author DaoyuanWang
 */
public class GenericIdUtil {

    /**
     * 生成18位会员编号
     */
    public static Long genericMemberId() {
        return Long.valueOf(DateUtil.FORMAT_YEAR_2_MIN.get().format(new Date()) + RandomUtil.generateNumberString(6));
    }

    /**
     * 生成16位消费单号
     */
    public static String genericConsumeNo() {
        return DateUtil.FORMAT_YEAR_2_MIN.get().format(new Date()) + RandomUtil.generateNumberString(4);
    }

    public static void main(String[] args) {
        System.out.println(genericMemberId());
    }
}

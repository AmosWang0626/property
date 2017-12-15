package cn.zut.common.util;

import java.util.Date;

/**
 * PROJECT: catherine
 * DATE: 2017/11/20
 *
 * @author DaoyuanWang
 */
public class GenericIdUtil {

    /**
     * 生成18位会员编号
     */
    public static Long genericMemberId() {
        StringBuffer sb = new StringBuffer();
        sb.append(DateUtil.format(new Date(), DateUtil.MINUTE_DATE_PATTERN));
        sb.append(RandomUtil.generateNumberString(6));

        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(genericMemberId());
    }
}

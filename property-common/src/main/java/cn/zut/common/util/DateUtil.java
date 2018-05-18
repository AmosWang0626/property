package cn.zut.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author DaoyuanWang
 */
public class DateUtil {

    public static final ThreadLocal<DateFormat> FORMAT_YEAR_2_DAY =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    private static final ThreadLocal<DateFormat> FORMAT_YEAR_2_DAY_SLOPE =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy/MM/dd"));
    private static final ThreadLocal<DateFormat> FORMAT_YEAR_2_MONTH =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM"));
    private static final ThreadLocal<DateFormat> FORMAT_MONTH_2_DAY =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd"));
    private static final ThreadLocal<DateFormat> FORMAT_MONTH =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("MM"));
    public static final ThreadLocal<DateFormat> FORMAT_YEAR =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy"));
    /**
     * hh 小写 12小时时间制
     * HH 大写 24小时时间制
     */
    public static final ThreadLocal<DateFormat> FORMAT_YEAR_2_SECOND =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static final ThreadLocal<DateFormat> FORMAT_YEAR_2_MIN =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmm"));

    /**
     * 获取指定日期开始时间
     *
     * @param date 指定日期
     * @return 开始日期
     */
    public static Date getDayStartTime(Date date) {
        try {
            return FORMAT_YEAR_2_SECOND.get().parse(FORMAT_YEAR_2_DAY.get().format(date) + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取指定日期最后时间
     *
     * @param date 指定日期
     * @return 最后日期
     */
    public static Date getDayEndTime(Date date) {
        try {
            return FORMAT_YEAR_2_SECOND.get().parse(FORMAT_YEAR_2_DAY.get().format(date) + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取上个月第一天到最后一天
     * ps: 02/01-02/28
     */
    public static String getPreMonthDayFirst2Last() {
        StringBuilder sb = new StringBuilder();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, -1);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        sb.append(FORMAT_MONTH_2_DAY.get().format(ca.getTime()));
        sb.append("-");
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        sb.append(FORMAT_MONTH_2_DAY.get().format(ca.getTime()));
        return sb.toString();
    }

    /**
     * 获取指定日期的 上个月 第一天到最后一天
     * ps: 2018/01/01-2018/01/31
     */
    public static String getPreMonthDayFirst2Last(Date date) {
        StringBuilder sb = new StringBuilder();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, -1);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        sb.append(FORMAT_YEAR_2_DAY_SLOPE.get().format(ca.getTime()));
        sb.append("-");
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        sb.append(FORMAT_YEAR_2_DAY_SLOPE.get().format(ca.getTime()));
        return sb.toString();
    }

    /**
     * 获取上个月第一天日期
     */
    public static Date getPreMonthFirstDay() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, -1);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
    }

    /**
     * 获取上个月最后一天日期
     */
    public static Date getPreMonthLastDay() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, -1);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    /**
     * 获取上个月日期
     * ps: 2018-03
     */
    public static String getPreMonth() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, -1);
        return FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
    }

    /**
     * 获取 指定日期上个月日期
     * ps: 2018-03
     */
    public static String getPreMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, -1);
        return FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
    }

    /**
     * 获取当月月份
     * ps: 2018-03
     */
    public static String getMonth() {
        return FORMAT_YEAR_2_MONTH.get().format(new Date());
    }

    /**
     * 获取 指定日期月份
     * ps: 2018-03
     */
    public static String getMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
    }

    /**
     * 获取下个月月份
     * ps: 2018-06
     */
    public static String getNextMonth() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, 1);
        return FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
    }

    /**
     * 获取下个月月份
     * ps: 2018-06
     */
    public static String getNextMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, 1);
        return FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
    }

    /**
     * parameter: billMonth [2018-05]
     * parameter: day       [1-31]
     * 根据月份获取指定日期
     *
     * @param billMonth 账单月份
     * @return Date 格式转换错误返回 null
     */
    public static Date getDateByMonthAndDay(String billMonth, int day) {
        try {
            Date parseDate = DateUtil.FORMAT_YEAR_2_MONTH.get().parse(billMonth);
            Calendar ca = Calendar.getInstance();
            ca.setTime(parseDate);
            ca.set(Calendar.DAY_OF_MONTH, day);
            return ca.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期之间相差的天数
     * bigDate - smallDate 参数2 减 参数1 得到相差天数
     *
     * @param smallDate 较小的时间
     * @param bigDate   较大的时间
     * @return 相差天数
     */
    public static int daysBetween(Date smallDate, Date bigDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(smallDate);
        long time1 = ca.getTimeInMillis();
        ca.setTime(bigDate);
        long time2 = ca.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 比较两个日期大小
     *
     * @param smallDate 较小的时间
     * @param bigDate   较大的时间
     * @return 后者比前者大: true;
     */
    public static boolean checkDateSize(Date smallDate, Date bigDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(smallDate);
        long time1 = ca.getTimeInMillis();
        ca.setTime(bigDate);
        long time2 = ca.getTimeInMillis();
        return (time2 - time1) > 0;
    }
}

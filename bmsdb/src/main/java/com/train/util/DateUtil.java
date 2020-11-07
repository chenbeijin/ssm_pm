package com.train.util;

import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 *
 * @author Xu Chunfu
 */
public final class DateUtil {

    /**
     * 获取当前的年
     *
     * @return
     */
    public static String getYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "";
    }

    /**
     * 获取当前的月
     *
     * @return
     */
    public static String getMonth() {
        Calendar c = Calendar.getInstance();
        return (c.get(Calendar.MONTH) + 1) < 10 ? "0"
                + (c.get(Calendar.MONTH) + 1) : ""
                + (c.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取当前的日
     *
     * @return
     */
    public static String getDay() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE) < 10 ? "0" + c.get(Calendar.DATE) : ""
                + c.get(Calendar.DATE);
    }

    /**
     * 获取当前的小时
     *
     * @return
     */
    public static String getHour() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY) < 10 ? "0"
                + c.get(Calendar.HOUR_OF_DAY) : ""
                + c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前的分
     *
     * @return
     */
    public static String getMinute() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MINUTE) < 10 ? "0" + c.get(Calendar.MINUTE) : ""
                + c.get(Calendar.MINUTE);
    }

    /**
     * 获取当前的秒
     *
     * @return
     */
    public static String getSeconds() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.SECOND) < 10 ? "0" + c.get(Calendar.SECOND) : ""
                + c.get(Calendar.SECOND);
    }

    /**
     * 获取当前的星期
     *
     * @return
     */
    public static int getWeek() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static String getWeekZhCN() {
        Calendar c = Calendar.getInstance();
        String ret = "星期";
        switch (c.get(Calendar.DAY_OF_WEEK) - 1) {
            case 0: {
                ret += "日";
                break;
            }
            case 1: {
                ret += "一";
                break;
            }
            case 2: {
                ret += "二";
                break;
            }
            case 3: {
                ret += "三";
                break;
            }
            case 4: {
                ret += "四";
                break;
            }
            case 5: {
                ret += "五";
                break;
            }
            case 6: {
                ret += "六";
                break;
            }
        }
        return ret;
    }

    /**
     * 字符串转换为java.util.Date<br>
     *
     * @param time String 字符串<br>
     * @return Date 日期<br>
     * 支持格式为 yyyy.MM.dd G 'at' hh:mm:ss z 如 '2011-1-1 AD at 22:10:59
     * PSD'<br>
     * yy/MM/dd HH:mm:ss 如 '2011/1/1 17:55:00'<br>
     * yy/MM/dd HH:mm:ss pm 如 '2011/1/1 17:55:00 pm'<br>
     * yy-MM-dd HH:mm:ss 如 '2011-1-1 17:55:00' <br>
     * yy-MM-dd HH:mm:ss am 如 '2011-1-1 17:55:00 am' <br>
     */
    public static Date stringToDate(String time) {
        SimpleDateFormat formatter;
        int tempPos = time.indexOf("AD");
        time = time.trim();
        formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
        if (tempPos > -1) {
            time = time.substring(0, tempPos) + "公元"
                    + time.substring(tempPos + "AD".length());// china
            formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
        }
        tempPos = time.indexOf("-");
        if (tempPos > -1 && (time.indexOf(" ") < 0)) {
            formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");
        } else if ((time.indexOf("/") > -1) && (time.indexOf(" ") > -1)) {
            formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        } else if ((time.indexOf("-") > -1) && (time.indexOf(" ") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if ((time.indexOf("/") > -1) && (time.indexOf("am") > -1)
                || (time.indexOf("pm") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        } else if ((time.indexOf("-") > -1) && (time.indexOf("am") > -1)
                || (time.indexOf("pm") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        }
        ParsePosition pos = new ParsePosition(0);
        java.util.Date ctime = formatter.parse(time, pos);
        return ctime;
    }

    /**
     * 日期格式的转化
     *
     * @param strDate    日期字符串
     * @param oldformate 日期字符串日期格式 <li>日期字符串支持格式[长格式,短格式]:</li><br>
     *                   <code>
     *                   <ol>
     *                   <li>yyyy年MM月dd日 例如:2011年7月3日  |2011年07月13日</li>
     *                   <li>yyyy.MM.dd    例如:2011.08.31 |2011.8.3 </li>
     *                   <li>yyyy-MM-dd    例如:2011-09-05 |2011-9-5</li>
     *                   </ol>
     *                   </code>
     * @param newformate 新的日期格式 <code>
     *                   <li>格式字符串说明</li>
     *                   <ol>
     *                   <li>yyyy代表年</li>
     *                   <li>MM代表月</li>
     *                   <li>dd代表日</li>
     *                   <li>HH代表小时</li>
     *                   <li>mm代表分</li>
     *                   <li>ss代表秒</li>
     *                   <li>E 代表星期</li>
     *                   </ol>
     *                   例如: "yyyy-MM-dd HH:mm:ss E"; 2011-09-08 10:11:05 星期四
     *                   </code>
     * @return 日期字符串 <br>
     * 举例: <br>
     * convertFormate("2011年9月8日","yyyy年MM月dd日","yyyy-MM-dd")
     */
    public static String convertFormate(String strDate, String oldformate,
                                        String newformate) {
        int year = 0;
        int month = 0;
        int day = 0;

        if (oldformate.equalsIgnoreCase("yyyy-MM-dd")) {
            year = Integer.parseInt(strDate.substring(0, strDate.indexOf("-")));
            month = Integer.parseInt(strDate.substring(
                    strDate.indexOf("-") + 1, strDate.lastIndexOf("-")));
            day = Integer.parseInt(strDate.substring(
                    strDate.lastIndexOf("-") + 1, strDate.length()));
        }

        if (oldformate.equalsIgnoreCase("yyyy年MM月dd日")) {
            year = Integer.parseInt(strDate.substring(0, strDate.indexOf("年")));
            month = Integer.parseInt(strDate.substring(
                    strDate.indexOf("年") + 1, strDate.lastIndexOf("月")));
            day = Integer.parseInt(strDate.substring(
                    strDate.lastIndexOf("月") + 1, strDate.lastIndexOf("日")));
        }

        if (oldformate.equalsIgnoreCase("yyyy.MM.dd")) {
            year = Integer.parseInt(strDate.substring(0, strDate.indexOf(".")));
            month = Integer.parseInt(strDate.substring(
                    strDate.indexOf(".") + 1, strDate.lastIndexOf(".")));
            day = Integer.parseInt(strDate.substring(
                    strDate.lastIndexOf(".") + 1, strDate.length()));
        }

        SimpleDateFormat dateformat = new SimpleDateFormat(newformate);
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date d1 = new Date(c.getTimeInMillis());
        return dateformat.format(d1);
    }

    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
     *
     * @param time Date 日期<br>
     * @return String 字符串<br>
     */
    public static String dateToString(Date time) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }

    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br>
     *
     * @param time Date 日期<br>
     * @param x    int 任意整数如：1<br>
     * @return String 字符串<br>
     */
    public static String dateToString(Date time, int x) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        String ctime = formatter.format(time);
        return ctime;
    }

    /**
     * 取系统当前时间:返回只值为如下形式 2011-10-30 20:24:39
     *
     * @return String
     */
    public static String Now() {
        return dateToString(new Date());
    }

    /**
     * 获取月的最后一天
     *
     * @param year
     * @param month 真实月份
     * @return
     */
    public static String getMonthLastDay(String year, String month) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
        int dd = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return dd < 10 ? "0" + dd : "" + dd;
    }

    /**
     * 获取当前日期时间 yyyy.mm.dd hh:mi:ss
     *
     * @return
     */
    public static String getCurrDateTime() {
        return getYear() + "." + getMonth() + "." + getDay() + " " + getHour()
                + ":" + getMinute() + ":" + getSeconds();
    }

    /**
     * 获取当前日期时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getCurrDateTime(String format) {
        String ret = "";
        try {
            Format formatter = new SimpleDateFormat(format);
            ret = formatter.format(new Date());
        } catch (Exception e) {
            ret = getCurrDateTime();
        }
        return ret;
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    /**
     * 获取当前年月
     *
     * @return
     */
    public static String getCurrMonth() {
        return getYear() + "-" + getMonth();
    }

    /**
     * 获取当前月第一天 YYYY.mm.dd
     *
     * @return
     */
    public static String getFirstDate() {
        return getYear() + "." + getMonth() + ".01";
    }

    /**
     * 获取当前月最后一天 YYYY.mm.dd
     *
     * @return
     */
    public static String getLastDate1() {
        return getYear() + "." + getMonth() + "."
                + getMonthLastDay(getYear(), getMonth());
    }

    /**
     * 获取当前月第一天 YYYY-mm-dd
     *
     * @return
     */
    public static String getFirstDate2() {
        return getYear() + "-" + getMonth() + "-01";
    }

    /**
     * 获取当前月最后一天 YYYY-mm-dd
     *
     * @return
     */
    public static String getLastDate2() {
        return getYear() + "-" + getMonth() + "-"
                + getMonthLastDay(getYear(), getMonth());
    }

    /**
     * 两个日期相隔天数
     *
     * @param beginDate yyyy.MM.dd
     * @param endDate   yyyy.MM.dd
     * @return
     */
    public static int DateDiff(String beginDate, String endDate) {
        Calendar cal1 = convertStrTo(beginDate);
        Calendar cal2 = convertStrTo(endDate);
        int result = (int) ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        return result;
    }

    /**
     * 将字符串日期转化为Calendar
     *
     * @param date YYYY.MM.DD
     * @return
     */
    public static Calendar convertStrTo(String date) {
        String yyyy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(yyyy));
        cal.set(Calendar.MONTH, Integer.parseInt(mm) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dd));
        return cal;
    }

    /**
     * 当前日期天加若干天
     *
     * @param curDate
     * @param offset
     * @return
     */
    public static String DateAddDay(String curDate, int offset) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar c = convertStrTo(curDate);
        c.add(Calendar.DAY_OF_MONTH, offset);
        Date d1 = new Date(c.getTimeInMillis());
        return dateformat.format(d1);
    }

    /**
     * 当前日期加若干月
     *
     * @param curDate
     * @param offset
     * @return
     */
    public static String DateAddMonth(String curDate, int offset) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar c = convertStrTo(curDate);
        c.add(Calendar.MONTH, offset);
        Date d1 = new Date(c.getTimeInMillis());
        return dateformat.format(d1);
    }

    /**
     * 当前日期加若干年
     *
     * @param curDate
     * @param offset
     * @return
     */
    public static String DateAddYear(String curDate, int offset) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar c = convertStrTo(curDate);
        c.add(Calendar.YEAR, offset);
        Date d1 = new Date(c.getTimeInMillis());
        return dateformat.format(d1);
    }

    /**
     * 获取当前系统日期
     */
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

//	public static void main(String[] args) {
//		Calendar cal1 = convertStrTo("2013.12.01");
//		Calendar cal2 = convertStrTo("2014.12.02");
//		int result = (int) ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24 * 60 * 60 * 1000));
//		System.out.println("相差了 " + result + "天");
//		int count = result / 365;
//		int days = result % 365;
//		System.out.println(count + "年" + days + "天");
//	}
}

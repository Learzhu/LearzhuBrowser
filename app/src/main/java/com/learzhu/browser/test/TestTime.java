package com.learzhu.browser.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/13 17:21
 * @update Learzhu 2017/3/13 17:21
 * @updateDes
 */

public class TestTime {
    public static SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.CHINA);
    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
    public static SimpleDateFormat formatWithWeek = new SimpleDateFormat("yyyy-MM-dd EE HH mm", Locale.CHINA);
    public static SimpleDateFormat weatherDayFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    private static SimpleDateFormat detailDateFormat = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
    private static SimpleDateFormat detailDateFormatWithYear = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
    private static SimpleDateFormat dateFormatyyyyMMdd10 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    /**
     * yyyy-MM-dd格式化对象。
     */
    private static final DateFormat yyyyMMdd10Df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 以yyyy-MM-dd格式，把字符串日期转化为日期对象。
     *
     * @param strDate 字符串日期
     * @return 日期对象
     */
    public synchronized static Date parseByyyyyMMdd10(String strDate) {
        try {
            return yyyyMMdd10Df.parse(strDate);
        } catch (ParseException e) {
            // 忽略;
        }
        return null;
    }

    /**
     * 以yyyy-MM-dd格式，格式化日期对象。
     *
     * @param date 日期对象
     * @return yyyy-MM-dd格式的日期字符串
     */
    public synchronized static String formatByyyyyMMdd10(Date date) {
        return yyyyMMdd10Df.format(date);
    }


    //    static String time = "2015-03-12 17:30:30";
//    static String time = "20150312173030";
    static String time = "20170406173030";
    static String time1 = "20170503094607";

    public static void main(String args[]) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(formatWithWeek.format(calendar.getTime()));

        System.out.println("time----" + time);
        System.out.println("getPublishTime()" + getPublishTime(time));
        System.out.println("getYearsAgoPublishTime()" + getYearsAgoPublishTime(time));
        System.out.println("getPublishTimeFormatted()" + getPublishTimeFormatted(time));
        System.out.println("getYearNow--" + getYearNow());
        System.out.println("getBetweenDays--" + getBetweenDays());
        getTimeDiff();

        System.out.println("getTimeyyyyMMdd10--" + getTimeyyyyMMdd10(time));
    }

    public static String getPublishTimeFormatted(String pubTime) {
        String str = "";
        try {
            Date pubDate = format.parse(pubTime);
            String yearPublish = formatYear.format(pubDate);
            System.out.println("year yearPublish " + yearPublish);
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int year = c.get(Calendar.YEAR);
            System.out.println("year now " + year);
            if (year - Integer.parseInt(yearPublish) >= 1) {
                //如果是超过一年的就显示带年份的日期
                str = getYearsAgoPublishTime(pubTime);
            } else {
                str = getPublishTime(pubTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getPublishTime(String pubTime) {
        String str = "";
        try {
            Date pubDate = format.parse(pubTime);
            str = detailDateFormat.format(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获取一年前的发布时间[带年份]
     *
     * @param pubTime
     * @return
     */
    public static String getYearsAgoPublishTime(String pubTime) {
        String str = "";
        try {
            Date pubDate = format.parse(pubTime);
            str = detailDateFormatWithYear.format(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @param pubTime
     * @return
     */
    public static String getTimeyyyyMMdd10(String pubTime) {
        String str = "";
        try {
            Date pubDate = format.parse(pubTime);
            str = dateFormatyyyyMMdd10.format(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getYearNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);
        return formatDate;
    }

    public static void getTimeDiff() {
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    public static String getBetweenDays() {
        try {
            Date pubDate = format.parse(time);
            Date nowDate = new Date();
            nowDate.setTime(System.currentTimeMillis());
            long between = nowDate.getTime() - pubDate.getTime();
            int day = (int) (between / (24 * 60 * 60 * 1000));
            int dateBetween = nowDate.getDate() - pubDate.getDate();
            return dateBetween == 1 ? "昨天" : dateBetween + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}

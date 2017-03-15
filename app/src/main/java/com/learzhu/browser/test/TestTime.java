package com.learzhu.browser.test;

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
    public static SimpleDateFormat weatherDayFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    private static SimpleDateFormat detailDateFormat = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
    private static SimpleDateFormat detailDateFormatWithYear = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);

    //    static String time = "2015-03-12 17:30:30";
    static String time = "20150312173030";

    public static void main(String args[]) {
        System.out.println("time----" + time);
        System.out.println("getPublishTime()" + getPublishTime(time));
        System.out.println("getYearsAgoPublishTime()" + getYearsAgoPublishTime(time));
        System.out.println("getPublishTimeFormatted()" + getPublishTimeFormatted(time));
        System.out.println("getYearNow--" + getYearNow());
        getTimeDiff();
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
}

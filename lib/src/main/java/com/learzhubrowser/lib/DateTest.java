package com.learzhubrowser.lib;

import java.util.Date;

/**
 * DateTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2020/12/18 17:18
 * @update Learzhu 2020/12/18 17:18
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class DateTest {
    public static void main(String args[]) {
//        System.out.println(DateUtils.getMonthDayHourMinFromFullDateString("2020-12-18 10:54:43"));
//        System.out.println(DateUtils.getMonthDayHourMinFromFullDateString("2020-12-18 10:51:05"));
//        System.out.println(DateUtils.getMonthDayHourMinFromFullDateString("2020-12-18 10:51:05"));
//        System.out.println(DateUtils.getFormatDatetimeDayStart(new Date()));
//        System.out.println(DateUtils.getMonthDayHourMinFromFullDateString(DateUtils.getCurrentDateStr()));
        System.out.println(DateUtils.getDateFormat(new Date(), DateUtils.FORMAT_DATETIME));
    }
}

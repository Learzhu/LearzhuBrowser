package com.learzhu.browser.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {

    public final static String FORMAT_DATE = "yyyy-MM-dd";
    public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_TIME = "HH:mm:ss";
    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE_ZH = "yyyy年MM月dd日";
    public final static String FORMAT_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";

    public final static String TYPE_DATE = "date";
    public final static String TYPE_DATETIME = "datetime";
    public final static String TYPE_DATE_TIME = "date_time";
    public final static String TYPE_TIME = "time";
    public static final SimpleDateFormat sformat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 日期排序类型-升序
     */
    public final static int DATE_ORDER_ASC = 0;

    /**
     * 日期排序类型-降序
     */
    public final static int DATE_ORDER_DESC = 1;

    private static final String baseFormate = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间转化成Date
     */
    public static Date getDate(String time) {
        return getDate(time, baseFormate);
    }

    /**
     * 时间转化成Date
     *
     * @param time
     * @param formate
     * @return
     */
    public static Date getDate(String time, String formate) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(formate);
            date = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @return
     */
    public static String getCurrentDateStr() {
        return getCurrentDateStr(baseFormate);
    }

    /**
     * @param formate
     * @return
     */
    public static String getCurrentDateStr(String formate) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat(formate);
        String dateStr = df.format(date);
        return dateStr;
    }

    /**
     * 获取当前时间
     */
    public static Date getCurrentTime() {

        return getCurrentTime(baseFormate);
    }

    /**
     * 获取当前时间
     */
    public static Date getCurrentTime(String formate) {
        SimpleDateFormat formatter = new SimpleDateFormat(formate);
        Date curDate = new Date(System.currentTimeMillis());
        String date = formatter.format(curDate);
        return getDate(date);
    }

    public static boolean before(String date1, String date2, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date d1 = new Date();
        Date d2 = d1;

        try {
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d1.before(d2);
    }

    public static boolean after(String date1, String date2, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date d1 = new Date();
        Date d2 = d1;

        try {
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d1.after(d2);
    }

    public static String getFutherDate(int day, String dateStr, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr.substring(0, 10)).getTime()
                    + (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

    public static String getFutherDate(int day, String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr.substring(0, 10)).getTime()
                    + (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return d;
    }

    public static String getBeforeDate(int day, String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr).getTime()
                    - (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return d;
    }

    public static String reFormat(String date, String f1, String f2) {
        SimpleDateFormat df1 = new SimpleDateFormat(f1);
        SimpleDateFormat df2 = new SimpleDateFormat(f2);
        Date d1 = new Date();
        try {
            d1 = df1.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return df2.format(d1);
    }

    public static Map<String, Object> getMyDate(int count) {
        Map<String, Object> map = new HashMap<String, Object>();
        Date currentDate = Calendar.getInstance().getTime();
        Calendar cl = Calendar.getInstance();
        cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH) + count);
        System.out.println(formatZh(currentDate, TYPE_DATE));
        System.out.println(formatZh(cl.getTime(), TYPE_DATE));
        Date endDate = cl.getTime();
        List<Date> mDateList = getBetweenDates(currentDate, endDate);
        map.put("date", mDateList);
        String[] name = new String[mDateList.size()];
        if (mDateList != null) {
            for (int i = 0; i < mDateList.size(); i++) {
                Date d = mDateList.get(i);
                if (i == 0) {
                    name[i] = "今天";
                } else if (i == 1) {
                    name[i] = "明天";
                } else if (i == 2) {
                    name[i] = "后天";
                } else {
                    name[i] = getDateAndWeek(d);
                }
            }
        }
        map.put("name", name);
        return map;

    }

    /**
     * 转换日期对象为中文化日期
     *
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型, date和datetime
     */
    public static String formatZh(Date dateValue, String dateType) {
        if (dateValue == null)
            return "";
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof Date) {
            switch (dateType) {
                case TYPE_DATE:
                    SimpleDateFormat sfdate = new SimpleDateFormat(
                            FORMAT_DATE_ZH);
                    return sfdate.format(dateValue);
                case TYPE_DATETIME:
                    SimpleDateFormat sftime = new SimpleDateFormat(
                            FORMAT_DATETIME_ZH);
                    return sftime.format(dateValue);
                default:
                    return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param t1 时间1
     * @param t2 时间2
     * @return t2 与t1的间隔天数
     * @throws ParseException 如果输入的日期格式不一致0000-00-00 格式抛出异常
     * @author color
     */
    public static int getBetweenDays(String t1, String t2)
            throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int betweenDays = 0;
        Date d1 = format.parse(t1);
        Date d2 = format.parse(t2);
        betweenDays = getBetweenDays(d1, d2);
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔天数
     */
    private static int getBetweenDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        int betweenDays;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        if (c1.after(c2)) {
            c2.setTime(d1);
            c1.setTime(d2);
        }
        int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        betweenDays = c2.get(Calendar.DAY_OF_YEAR)
                - c1.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < betweenYears; i++) {
            c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
            betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
        }
        return betweenDays;
    }

    public static String getDateAndWeek(Date date) {
        return formatZh(date, TYPE_DATE).substring(5) + date2Week(date);
    }

    public static String date2Week(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        return DateUtil.WeekToweek(sdf.format(date));
    }

    /**
     * 星期几转换成周几
     *
     * @param str
     * @return
     */
    public static String WeekToweek(String str) {
        if (str.equals("星期天")) {
            return "周日";
        } else if (str.equals("星期一")) {
            return "周一";
        } else if (str.equals("星期二")) {
            return "周二";
        } else if (str.equals("星期三")) {
            return "周三";
        } else if (str.equals("星期四")) {
            return "周四";
        } else if (str.equals("星期五")) {
            return "周五";
        } else if (str.equals("星期六")) {
            return "周六";
        } else {
            return str;
        }
    }

    public static List<Date> getBetweenDates(Date fromDate, Date toDate) {
        List<Date> result = new ArrayList<Date>();
        // 如果�?始日期大于结束日期交�?
        if (toDate.getTime() < fromDate.getTime()) {
            Date tempDate = fromDate;
            fromDate = toDate;
            toDate = tempDate;
        }

        Calendar ca = Calendar.getInstance();
        while (fromDate.getTime() <= toDate.getTime()) {
            ca.setTime(fromDate);
            Date tempDate = new Date(ca.getTime().getTime());
            result.add(tempDate);
            ca.add(Calendar.DATE, 1);
            fromDate = new java.sql.Date(ca.getTime().getTime());
        }
        return result;
    }

    /**
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型, date和datetime
     */
    public static String format(Object dateValue, String dateType) {
        if (dateValue == null)
            return "";
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof Date) {
            if (dateType.equals(TYPE_DATE)) {
                SimpleDateFormat sfdate = new SimpleDateFormat(
                        FORMAT_DATE);
                return sfdate.format(dateValue);
            } else if (dateType.equals(TYPE_DATETIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_DATETIME);
                return sftime.format(dateValue);
            } else if (dateType.equals(TYPE_DATE_TIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_DATE_TIME);
                return sftime.format(dateValue);
            } else if (dateType.equals(TYPE_TIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_TIME);
                return sftime.format(dateValue);
            } else {
                return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }


    /**
     * 秒速转时分秒格式
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
//                if (hour > 99)
//                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    /**
     * 秒速转时分秒格式
     *
     * @param time
     * @return
     */
    public static String secToDayTime(int time) {
        String timeStr = null;
        int day = 0;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00分00秒";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + "分" + unitFormat(second) + "秒";
            } else {
                hour = minute / 60;
                if (hour < 24) {
                    minute = (time / 60) % 60;
                    second = time % 60;
                    timeStr = unitFormat(hour) + "时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
                } else {
                    day = (time / 86400) % 24;
                    hour = (time / 3600) % 24;
                    minute = (time / 60) % 60;
                    second = time % 60;
                    timeStr = day + "天" + unitFormat(hour) + "时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
                }
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }


    /**
     * 得到 HH:mm:ss的时间从毫秒输里面
     *
     * @param msec 毫秒数
     * @return 格式化后的时间
     */
    public static String getLeftFormatTimeFromMsec(long msec) {
        StringBuilder stringBuilder = new StringBuilder();
        long timeSecond = msec / 1000;
        long hour = timeSecond / 3600;
        long minute = (timeSecond % 3600) / 60;
        long second = timeSecond % 60;
        stringBuilder.append(getAlignNumber(hour) + ":" + getAlignNumber(minute) + ":" + getAlignNumber(second));
        return stringBuilder.toString();
    }

    /**
     * 获取到多少天多少小时多少
     *
     * @param msec 毫秒数
     * @return 格式化后的时间：2天2小时0分
     */
    public static String getDayHourMinTimeFromMsec(long msec) {
        StringBuilder stringBuilder = new StringBuilder();
        long timeSecond = msec / 1000;
        long hour = timeSecond / 3600;
        long day = hour / 24;
        long minute = (timeSecond % 3600) / 60;
        long second = timeSecond % 60;
        //多少天
        if (day > 0) {
            stringBuilder.append(day).append("天");
        }
        //多少小时
        if (hour > 0) {
            stringBuilder.append(hour);
        }
        stringBuilder.append(minute).append("分钟");
        return stringBuilder.toString();
    }

    /**
     * 自动补0的方法
     *
     * @param number 数字
     * @return 返回结果字符串 例如 number为10 返回10 如果为9那就返回09
     */
    public static String getAlignNumber(long number) {
        if (number >= 10) {
            return "" + number;
        } else {
            return "0" + number;
        }
    }


    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getFormatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

//    public static Date getFormatShortDate(Date date1) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = (Date) formatter.parse(str);
//
//        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
//        java.util.Date date = new Date(date1.getTime() * 1000);
//        String str = sdf.format(date);
//        System.out.println(str);
//    }


    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getFormatShortDate1(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        String dateString = formatter.format(date);
//        ParsePosition pos = new ParsePosition(8);
//        Date currentTime_2 = formatter.parse(dateString, pos);
        Date currentTime_2 = null;
        try {
            currentTime_2 = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentTime_2;
    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        return formatter.format(date);
    }

    public static Date getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date datetime = formatter.parse(dateString, pos);
        java.sql.Timestamp ts = null;
        if (datetime != null) {
            ts = new java.sql.Timestamp(datetime.getTime());
        }
        return ts;
    }


    /**
     * Date -> Timestamp
     * 父类不能直接向子类转化，可借助中间的String~~~~
     * java.sql.Date 只存储日期数据不存储时间数据
     *
     * @param date
     * @return
     */
//    public static Date getShortDate(Date date) {
//        java.sql.Date date1 = new java.sql.Date();
//        PreparedStatement preparedStatement = new PreparedStatement() {
//        };
//        // 会丢失时间数据
//        preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
////可以这样来处理
//        preparedStatement.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
////想要得到完整的数据，包括日期和时间，可以这样
//        java.util.Date d = resultSet.getTimestamp(1);
////这样处理更合适一些，可以避免一些潜在Timestamp 问题
//        java.util.Date d = new java.util.Date(resultSet.getTimestamp(1).getTime());
//    }
    public static Date getFormatShortDate2() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date datetime = formatter.parse(dateString, pos);
        java.sql.Timestamp ts = null;
        if (datetime != null) {
            ts = new java.sql.Timestamp(datetime.getTime());
        }
        String format = formatter.format(ts);
        Date parse = formatter.parse(format, new ParsePosition(0));
        return parse;
    }

//    public void timestampConvertString() {
//        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
//        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//        String timeStr = sdf.format(currentTime);
//        System.out.println(timeStr);
//    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDateX(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        return formatter.format(date);
    }

    /**
     * 获取时间戳
     *
     * @param date 当前的时间
     * @return 时间戳 "timestamp":"2017-07-08 12:12:12.123"
     */
    public static String getTimestamp(Date date) {
        return sformat3.format(date);
    }
}

package com.learzhu.browser.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * CalendarTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2021/10/12 18:24
 * @update Learzhu 2021/10/12 18:24
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class CalendarTest {
    public static void main(String args[]) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar selectedCalendar = Calendar.getInstance();
        selectedCalendar.set(selectedCalendar.get(Calendar.YEAR), 2, 31);
        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.format(new Date(selectedCalendar.getTimeInMillis())));
//        selectedCalendar.setTime(new Date());

        Calendar calendar = Calendar.getInstance();
        //当前选中的时间
        selectedCalendar.add(Calendar.MONTH, 1 );
        calendar.set(selectedCalendar.get(Calendar.YEAR), selectedCalendar.get(Calendar.MONTH), selectedCalendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTimeZone(selectedCalendar.getTimeZone());
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(dateFormat.format(new Date(calendar.getTimeInMillis())));
    }
}

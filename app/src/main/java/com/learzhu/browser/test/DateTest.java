package com.learzhu.browser.test;

import com.learzhu.browser.utils.DateUtil;
import com.learzhu.browser.utils.DateUtil1;

import java.util.Date;

/**
 * DateTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2017/10/17 13:48
 * @update Learzhu 2017/10/17 13:48
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class DateTest {
    public static void main(String args[]) {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("time: " + time);
        String resultTime = DateUtil.format(new Date(time), DateUtil.TYPE_DATETIME);
//        String resultTime = DateUtil.format(date, DateUtil.TYPE_DATETIME);
        System.out.println("result: " + resultTime);
        System.out.println(DateUtil1.sFormatNowDate2(date));
    }
}

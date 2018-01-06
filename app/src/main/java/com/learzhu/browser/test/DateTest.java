package com.learzhu.browser.test;

import com.learzhu.browser.utils.DateUtil;
import com.learzhu.browser.utils.DateUtil1;

import java.math.BigDecimal;
import java.util.Calendar;
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

        System.out.println(Integer.MAX_VALUE);
        //        testTime();
        Calendar selectedDate = Calendar.getInstance();
        System.out.println(selectedDate);
        BigDecimal bigDecimal1 = new BigDecimal(99999.0000);
        System.out.println(bigDecimal1.intValue());
        //该方法错误
//        String format = "共三件商品 合计：￥%d(运费：￥%f)";
//        String format = "共三件商品 合计：￥%d(运费：￥%.2f)";
//        String format = "共三件商品 合计：￥%1$d(运费：￥%2$.2f)";
        String format = "共%1$d件商品 合计：￥%2$d(运费：￥%3$.2f)";
//        String result = String.format(format, 1, 2.03);
//        System.out.println(result);
//        String format = "AAAAAAAAAAAAA%lf";
//        String format = "AA%f%n";
//        String format = "AA%f";
//        String result = String.format(format, 2, 2, 2.0333);
        String result = String.format(format, 2, 2, 2.3);
//        String result = String.format(format, 2.19);
        System.out.println(result);
        double ff = 2.0000d * 4.013;
        System.out.println(ff);

//        String string = "AAA%.2fBBB";
        String string = "AAA%.0fBBB";
        BigDecimal bigDecimal = new BigDecimal(2000.00);
        String result1 = String.format(string, bigDecimal);
        System.out.println(result1);

//        String test = "2.优惠券的折扣至少%d\\%";
//        System.out.println(String.format(test, 20));
        String test1 = "2.优惠券的折扣至少%d%%";
        System.out.println(String.format(test1, 20));
    }

    private static void testTime() {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(DateUtil.getFormatShortDate2());
        System.out.println(DateUtil.getFormatDate(date));
        System.out.println(DateUtil.getNowDateShort());
        System.out.println(DateUtil.getFormatShortDate(date));
        System.out.println(DateUtil.getDate());
        long time = date.getTime();
        System.out.println("time: " + time);
        String resultTime = DateUtil.format(new Date(time), DateUtil.TYPE_DATETIME);
//        String resultTime = DateUtil.format(date, DateUtil.TYPE_DATETIME);
        System.out.println("result: " + resultTime);
        System.out.println(DateUtil1.sFormatNowDate2(date));
        String time1 = "2017-11-02 14:35:08";
//        Date date1 = new Date(time1);
//        System.out.println(date1.getTime());
//        System.out.println(Date.parse(time1));
        System.out.println(DateUtil.getDate(time1).getTime());
    }
}

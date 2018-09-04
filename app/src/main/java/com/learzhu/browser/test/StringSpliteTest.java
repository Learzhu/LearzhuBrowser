package com.learzhu.browser.test;

import com.learzhu.browser.utils.StringUtils;

import java.io.File;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/29 19:50
 * @update Learzhu 2017/3/29 19:50
 * @updateDes
 */

public class StringSpliteTest {
    private static String testString = null;
//    private static String testString = "";

    private static String testString1 = "AAAA" + File.separator + "BBB.jpg";

    public static void main(String args[]) {
//        String[] split = testString.split(",");
        //空的还1
//        System.out.println("splite---" + split.length);
//        System.out.println(testString1);
//        String[] strings = StringUtils.splitSeparator(testString1);
//        if (ArrayUtils.isAvailable(strings)) {
//            String string = strings[strings.length - 1];
//            if (ObjectUtils.isObjectNotNull(string)) {
//                String[] strings1 = StringUtils.splitPoint(string);
//
//            }
//            System.out.println(string);
//        }

//        String dateWithoutSec = StringUtils.getDateWithoutSec("2018-05-06 12:22:33");
        String dateWithoutSec = StringUtils.getDateWithoutSec(" ");
        System.out.println(dateWithoutSec);
    }
}

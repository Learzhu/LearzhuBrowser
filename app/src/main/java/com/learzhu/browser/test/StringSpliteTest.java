package com.learzhu.browser.test;

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

    public static void main(String args[]) {
        String[] split = testString.split(",");
        //空的还1
        System.out.println("splite---" + split.length);
    }
}

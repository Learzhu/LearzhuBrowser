package com.learzhu.browser.test;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/4/27 15:30
 * @update Learzhu 2017/4/27 15:30
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class SpliteTest {
    private static String testString = "AAAAA1BBBBB1CCC";

    private static boolean isOk;

    public static void main(String args[]) {
        String[] split = testString.split("1", 1);
        int x = Integer.MAX_VALUE;
        System.out.println(x);
        System.out.println(isOk);
    }
}

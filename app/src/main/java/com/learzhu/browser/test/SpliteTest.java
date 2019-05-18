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

    private static int x = 15_000;
    private static int y = 15 / 000;

    public static void main(String args[]) {
        split2();
    }

    private static void split1() {
        String[] split = testString.split("1", 1);
//        int x = Integer.MAX_VALUE;
        System.out.println(x);
        System.out.println(isOk);
        System.out.println(" 15_000== 15    " + (x == 15));
        System.out.println("x = 15_000=" + x);
        System.out.println("15_000-1=    " + (x - 1));
        System.out.println("Integer.MAX_VALUE" + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE=x" + (Integer.MAX_VALUE == x));
        System.out.println("y=" + y);
        System.out.println("y=" + y / 1);
    }

    private static void split2() {
        String string = 2.0 + "," + true;
        System.out.println(string);
        String[] split = string.split(",");
        System.out.println(split.length > 1 ? "null" : split[0] + "&&&&" + split[1]);
    }
}

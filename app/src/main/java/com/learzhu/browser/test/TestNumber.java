package com.learzhu.browser.test;

import java.text.NumberFormat;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/13 18:01
 * @update Learzhu 2017/3/13 18:01
 * @updateDes
 */

public class TestNumber {
    static int i = 20;
    static int j = 30;
    static double k;
    static double l;

    public static void main(String args[]) {
        System.out.println(i / j);
        k = i / j;
        System.out.println(k);
        l = (float) i / j;
        System.out.println(l);
        System.out.println("% " + NumberFormat.getPercentInstance().format(l));
        System.out.println(Integer.MAX_VALUE);
    }
}

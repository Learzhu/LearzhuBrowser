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

        short s1 = 1;
        s1 = (short) (s1 + 1);

        ok:
        for (int m = 0; m < 100; m++) {
            ok1:
            for (int n = 0; n < 4; n++) {
                if (n == 2) {
                    continue ok1;
                }
            }
            if (m == 5) {
                break ok;
            }
        }
    }
}

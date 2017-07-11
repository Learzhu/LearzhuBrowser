package com.learzhu.browser.test;

import java.util.Date;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/11 10:41
 * @update Learzhu 2017/7/11 10:41
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class SortTimeTest {
    public static void main(String args[]) {
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1000000; i++) {
            int x = i * i + i;
        }
        System.out.println(System.currentTimeMillis());
    }
}

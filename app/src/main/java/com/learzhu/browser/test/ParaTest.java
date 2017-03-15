package com.learzhu.browser.test;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/13 11:51
 * @update Learzhu 2017/3/13 11:51
 * @updateDes
 */

public class ParaTest {
    public static void main(String args[]) {
        test();
        test(true);
    }

    public static void test(boolean... x) {
        if (x != null && x.length > 0) {
            System.out.println("test length" + x[0]);
        }
        System.out.println("test" + x);
    }

}

package com.learzhu.browser.test;

/**
 * PerformanceTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-02-20 17:24
 * @update Learzhu 2019-02-20 17:24
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class PerformanceTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int n = 0;
        for (int i = 0; i < 1000000000; i++) {
            n += 2 * i * i;
        }
        System.out.println("time of 2 * i * i" + (double) (System.nanoTime() - startTime) / 1000000000 + " s");
        System.out.println("n = " + n);
        long startTime1 = System.nanoTime();
        int m = 0;
        for (int i = 0; i < 1000000000; i++) {
            m += 2 * (i * i);
        }
        System.out.println("time of 2 * (i * i)" + (double) (System.nanoTime() - startTime1) / 1000000000 + " s");
        System.out.println("m = " + m);
    }
}

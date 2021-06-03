package com.learzhubrowser.lib;

/**
 * ReturnTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2021/1/21 15:11
 * @update Learzhu 2021/1/21 15:11
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class ReturnTest {
    public static void main(String args[]) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
            if (i < 10) {
                for (int j = 0; j < 10; j++) {
                    System.out.println(j);
                    if (j == 5) {
                        return;
                    }
                }
            }
        }
    }
}

package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.List;

/**
 * WhileTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2021/8/6 15:59
 * @update Learzhu 2021/8/6 15:59
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class WhileTest {
    public static void main(String args[]) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int i = 0;
        do {
            System.out.println(list.get(i));
            i++;
        } while (i < 10);
    }
}

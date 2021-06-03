package com.learzhubrowser.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * AAA.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2020/12/18 18:18
 * @update Learzhu 2020/12/18 18:18
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class AAA {

    public static void main(String[] args) {
//        System.out.println("sum:" + sum(1, 2, 3, 6, 5, 8, 9));
//        System.out.println(sum());
//        System.out.println(System.currentTimeMillis());
        List<String> list = new ArrayList();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static int sum(int... a) {
        int sum = 0;

        for (int x : a) {
            sum += x;
        }
        return sum;
    }


}

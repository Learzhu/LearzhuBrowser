package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * SortStringTest.java是液多多的类。
 *
 * @author Learzhu
 * @version 2019-12-31 09:44
 * @update Learzhu 2019-12-31 09:44
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class SortStringTest {
    public static void main(String args[]) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("D");
        list1.add("A");
        list1.add("C");
        list1.add("B");
        list1.add("1");
        list1.add("5");
        list1.add("中");
        list1.add("#");
        Collections.sort(list1, (o1, o2) -> o1.compareTo(o2));
        for (String string : list1) {
            System.out.println(string);
        }
    }
}

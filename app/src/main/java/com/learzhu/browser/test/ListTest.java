package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/5 17:55
 * @update Learzhu 2017/8/5 17:55
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ListTest {
    public static void main(String args[]) {
//        List<Object> list = new ArrayList();
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List list1 = new ArrayList();
        list1.add(2);
        list.add(list1);

        List listOragin = new ArrayList();
        listOragin.add(1);
        listOragin.add(list1);

        System.out.println(list.get(0) + "  " + listOragin.get(0));
        testList(list);

        testList(listOragin);
    }

    public static void testList(List list) {
        Object o = list.get(0);
        System.out.println(o.toString());
    }
}

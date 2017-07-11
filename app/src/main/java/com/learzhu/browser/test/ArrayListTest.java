package com.learzhu.browser.test;

import java.util.ArrayList;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/6/23 10:05
 * @update Learzhu 2017/6/23 10:05
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
//        al.add(0, 8);
//        al.add(1, 10);
        al.add(2, 3);
        al.add(3, 20);
        al.add(4, 30);
        al.get(1);
//        al.add(2, 70); //在第三个元素的位置加入一个元素
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}

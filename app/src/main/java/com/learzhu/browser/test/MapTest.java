package com.learzhu.browser.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/6/27 14:25
 * @update Learzhu 2017/6/27 14:25
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class MapTest {
    private static Map<Integer, String> mMap = new HashMap<>();
    private static Map<Integer, String> mMap1 = new ConcurrentHashMap<>();

    public static void main(String args[]) {
        mMap.put(1, "AA");
        mMap.put(2, "BB");
        mMap.put(2, "CC");
        mMap.clear();
        System.out.println(mMap.get(2));
        System.out.println(mMap.get(3));

        for (int i = 0; i < 10000; i++) {
            mMap1.put(i, "我是" + i);
        }

        for (int i = 0; i < 10000; i++) {
            String s = mMap1.get(i);
            System.out.println(s);
        }
    }
}

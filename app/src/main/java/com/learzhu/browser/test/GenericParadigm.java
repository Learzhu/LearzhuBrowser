package com.learzhu.browser.test;

import java.util.HashSet;
import java.util.Set;

/**
 * GenericParadigm.java是LZCoolWeather的类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/4/3 15:41
 * @update UserName 2017/4/3 15:41
 * @updateDes
 */

public class GenericParadigm {
    public static void main(String args[]) {
//        GenericParadigm.union1()
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static Set union1(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}

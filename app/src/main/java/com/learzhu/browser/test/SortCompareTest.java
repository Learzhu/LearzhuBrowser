package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortCompareTest.java是液多多LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 2020/10/20 16:25
 * @update Learzhu 2020/10/20 16:25
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class SortCompareTest {


    public static void main(String args[]) {
        List<CompareA> list = new ArrayList<CompareA>();
        list.add(new CompareA("C", 4, 27, 22));
        list.add(new CompareA("A", 2, 20, 5));
        list.add(new CompareA("F", 6, 29, 42));
        list.add(new CompareA("C", 5, 20, 32));
        list.add(new CompareA("G", 7, 29, 36));
        list.add(new CompareA("D", 5, 27, 32));
        list.add(new CompareA("B", 3, 20, 15));
        list.add(new CompareA("E", 6, 27, 42));
        list.add(new CompareA("H", 7, 29, 1));
        Comparator<CompareA> comparator = new Comparator<CompareA>() {
            @Override
            public int compare(CompareA o1, CompareA o2) {
                if (o1.getAge() != o2.getAge()) {
                    //年龄不等按照年龄增序
                    return o1.getAge() - o2.getAge();
                }

                //组内按照size增序
                if (o1.getSize() != o2.getSize()) {
                    return o1.getSize() - o2.getSize();
                }
                return 0;
            }
        };
        Collections.sort(list, comparator);
        for (CompareA comparatora : list) {
            System.out.println(comparatora.toString());
        }
    }
}

class CompareA {
    public CompareA(String name, int num, int age, int size) {
        this.name = name;
        this.num = num;
        this.age = age;
        this.size = size;
    }

    String name;
    int num;
    int age;
    int size;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public int getAge() {
        return age;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CompareA{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", age=" + age +
                ", size=" + size +
                '}';
    }
}

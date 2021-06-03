package com.learzhubrowser.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 2020/11/6 13:59
 * @update Learzhu 2020/11/6 13:59
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class SortTest {
    public static void main(String args[]) {
        List<Student> list = new ArrayList<>();
//        list.add(new Student("#1", 1));
//        list.add(new Student("w", 1));
//        list.add(new Student("#我", 1));
//        list.add(new Student("我的好", 1));
//        list.add(new Student("是个", 1));
//        list.add(new Student("#7", 1));
//        list.add(new Student("88", 1));


        list.add(new Student("a", 1));
//        list.add(new Student("b", 4));
//        list.add(new Student("d", 5));
//        list.add(new Student("c", 9));


        Collections.sort(list, new NameComparator());
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}

class Student {
    String name;
    int num;

    Student(String s, int n) {
        name = s;
        num = n;
    }

    public String toString() {
        return name + "-" + num;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
//        if (o1.name.compareTo(o2.name) > 0)
//            return 1;
//        else if (o1.name.compareTo(o2.name) < 0)
//            return -1;
//        else
//            return o1.name.compareTo(o2.name);
//    }


//        if (o1.name.contains("#")) {
//            return -1;
//        } else {
//            return o1.name.compareTo(o2.name);
//        }

        int f = o1.num - o2.num;
        if (f == 0) {
            return 0;
        } else if (f > 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
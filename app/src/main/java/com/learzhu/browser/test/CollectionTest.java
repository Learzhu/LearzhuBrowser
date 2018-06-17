package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/16 20:53
 * @update Learzhu 2017/3/16 20:53
 * @updateDes
 */

public class CollectionTest {
    List mList = new ArrayList();

    List<A> mList1 = new ArrayList();

    public static void main(String args[]) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.init();
        collectionTest.ifStringConatin();
        collectionTest.ifAContain();
        collectionTest.subList();
        collectionTest.testEqual();
    }

    private void testEqual() {
        List<Attr> list = new ArrayList<>();
        list.add(new Attr("AA", "大"));
        list.add(new Attr("AA", "小"));
        list.add(new Attr("AA", "中"));
        list.add(new Attr("BB", "XX"));
        Set<String> attrValueIdsSet = new HashSet<String>();
        for (Attr attr : list) {
            attrValueIdsSet.add(attr.getAttr());
        }
        System.out.println("list.size() " + list.size() + " Set.size() " + attrValueIdsSet.size());
    }

    class Attr {
        String attr;
        String size;

        public Attr(String attr, String size) {
            this.attr = attr;
            this.size = size;
        }

        public String getAttr() {
            return attr;
        }

        public void setAttr(String attr) {
            this.attr = attr;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }
    }

    public void init() {
        mList.add("A");
        mList.add("B");
        mList.add("C");
        mList.add("D");

        mList1.add(new A("AA", 1));
        mList1.add(new A("BB", 2));
    }

    public List<String> subList() {
        return mList.subList(0, 3);
    }

    public void ifStringConatin() {
        boolean a = mList.contains("A");
        System.out.println("ifConatin+" + a);
    }

    private void ifAContain() {
        boolean aa = mList1.contains(new A("AA", 1));
        System.out.println("ifAContain " + aa);
    }

    class A {
        String name;
        int age;

        public A(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

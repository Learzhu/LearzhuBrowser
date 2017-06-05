package com.learzhu.browser.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/15 23:41
 * @update Learzhu 2017/3/15 23:41
 * @updateDes
 */

public class ListUnionIntersection {

    private List<Integer> mList1 = new ArrayList();
    private List<Integer> mList2 = new ArrayList();

    private void init() {
        mList1.add(1);
        mList1.add(2);
        mList1.add(3);
        mList1.add(4);
        mList2.add(1);
        mList2.add(3);
    }

    public List<Integer> removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public static void main(String args[]) {
        ListUnionIntersection listUnionIntersection = new ListUnionIntersection();
        listUnionIntersection.init();
//        List union = listUnionIntersection.getUnion();
////        System.out.println(union.toArray());
//        listUnionIntersection.print(union);
//        System.out.println("-------------");
//        listUnionIntersection.print(listUnionIntersection.getUnion1());
        System.out.println("---------------");
//        listUnionIntersection.print(listUnionIntersection.getSub());
        System.out.println("---------------交集");
        listUnionIntersection.print(listUnionIntersection.getIntersection());
        listUnionIntersection.mList1.subList(1, 1);
    }

    public void print(List<Integer> list) {
        for (int in :
                list) {
            System.out.print(in + " ");
        }
    }

    /**
     * 不重复的并集
     *
     * @return
     */
    private List getUnion1() {
        mList2.removeAll(mList1);
        mList1.addAll(mList2);
        return mList1;
    }

    /**
     * 获取并集
     *
     * @return
     */
    public List getUnion() {
        init();
        //合集合
        mList1.addAll(mList2);
        System.out.println(mList1.toArray());
        removeDuplicate(mList1);//前面所提的清除重复值
        mList1.addAll(mList2);
        return removeDuplicate(mList1);//前面所提的清除重复值
    }

    /**
     * 获取交集
     *
     * @return
     */
    public List getIntersection() {
        mList1.retainAll(mList2);
//        mList1.removeAll(mList2);
        return mList1;
    }

    /**
     * 取出差集
     * 相对补集
     *
     * @return
     */
    public List getSub() {
        mList1.removeAll(mList2);
        return mList1;
    }

    /**
     * 绝对补集
     *
     * @return
     */
    public List getAbsSub() {
        if (mList1.containsAll(mList2)) {
            mList1.removeAll(mList2);
        }
        return mList1;
    }
}

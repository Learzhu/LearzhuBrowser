package com.learzhu.browser.test;

/**
 * Set.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-03-11 10:11
 * @update Learzhu 2019-03-11 10:11
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//创建一个集合类set
public class SetCalculate {
    public static void main(String[] args) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>() {{
            System.out.println("请输入集合1的元素个数：");
            Scanner input = new Scanner(System.in);
            int max = input.nextInt();
            System.out.println("请输入一个集合：");//输入要用的集合，进行相关的运算
            Scanner input1 = new Scanner(System.in);
            int[] arr = new int[max];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) input1.nextInt();
                add(arr[i]);
            }
        }};
        System.out.println("集合1为: ");
        printlnSet(set1);
        System.out.println();
        Set<Integer> set2 = new HashSet<Integer>() {{
            System.out.println("请输入集合2的元素个数：");
            Scanner input = new Scanner(System.in);
            int max = input.nextInt();
            System.out.println("请再输入一个集合：");
            Scanner input1 = new Scanner(System.in);
            int[] a = new int[max];
            for (int i = 0; i < a.length; i++) {
                a[i] = (int) input1.nextInt();
                add(a[i]);
            }
        }};
        System.out.println("集合2为: ");
        printlnSet(set2);
        System.out.println();
        while (true) {
            calculate(result, set1, set2);
        }
    }

    /**
     * 计算集合
     *
     * @param result
     * @param set1
     * @param set2
     */
    private static void calculate(Set<Integer> result, Set<Integer> set1, Set<Integer> set2) {
        System.out.println("请输入操作指令：1代表执行交集；2代表执行差集；；3代表执行对称差集；4代表执行并集");
        //输入操作指令
        Scanner input = new Scanner(System.in);
        int aaa = input.nextInt();
        if (aaa == 1) {
            //求交集
            result.clear();
            result.addAll(set1);
            result.retainAll(set2);
            System.out.println("交集：" + result);
        } else if (aaa == 2) {
            //求差集
            result.clear();
            result.addAll(set1);
            result.removeAll(set2);
            System.out.println("差集：" + result);
        } else if (aaa == 3) {
            //求对称差集
            result.clear();
            result.addAll(set1);
            result.removeAll(set2);
            Set<Integer> a = result;
            System.out.println("差集：" + result);

            result.clear();
            result.addAll(set2);
            result.removeAll(set1);
            Set<Integer> b = result;
            result.clear();
            result.addAll(a);
            result.addAll(b);
            System.out.println("对称差集：" + result);
        } else {
            //求并集
            result.clear();
            result.addAll(set1);
            result.addAll(set2);
            System.out.println("并集：" + result);
        }
    }

    /**
     * set集合输出
     *
     * @param set
     */
    public static void printlnSet(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
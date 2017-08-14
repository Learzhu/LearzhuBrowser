package com.learzhu.browser.test.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 小易有一些彩色的砖块。每种颜色由一个大写
 * 字母表示。各个颜色砖块看起来都完全样。
 * 现在有个给定的字符串s，s中每个字符代表小
 * 易的某个砖块的颜色。小易想把他所的砖块
 * 排成一行。如果最多存在一对不同颜色的相邻
 * 砖块，那么这行砖块就很漂亮的。请你帮助小易
 * 计算有多少种方式将他所有砖块排成漂亮的一
 * 行。(如果两种方式所对应的砖块颜色序列是相
 * 同的，那么认为这两种方式是一样的。)
 * 例如: s ="ABAB",那么小易有六种排列的结果:
 * "AABB","ABAB'"ABBA","BAAB'","BABA","BB
 * AA"
 * 其中只有"ABB"和"BBAA"满足最多只有一对
 * 不同颜色的相邻砖块。
 * 输入描述:
 * 输入包括一个学符串s，字符串s的长度leng
 * th [1,50]，s中的每一个字符
 * 都为一个大写半母(A到Z)
 * <p>
 * 总结只有一种情况 两种字母而且排列方式就只有两种！！
 * <p>
 * 1.保存到集合Map
 * 2.遍历集合超过三种就失败
 */
public class SingleLineBrickTest {
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字母列表：");

//        scannMethod1(map, scanner);
        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(" ");
        for (String string :
                split) {
            getMap(map, string);
        }

        System.out.println();
        System.out.println("计算结果：");
        Set<String> strings = map.keySet();
        if (strings.size() == 2) {
            System.out.println("一共两种方案，如下：");
            Iterator<String> iterator = strings.iterator();
            String a = null, b = null;
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (a == null) {
                    a = next;
                } else {
                    b = next;
                }
            }

            System.out.println("方案一：");
            Integer integerA = map.get(a);
            Integer integerB = map.get(b);
            for (int i = 0; i < integerA; i++) {
                System.out.print(a + " ");
            }
            for (int i = 0; i < integerB; i++) {
                System.out.print(b + " ");
            }

            System.out.println("方案二：");
            for (int i = 0; i < integerB; i++) {
                System.out.print(b + " ");
            }
            for (int i = 0; i < integerA; i++) {
                System.out.print(a + " ");
            }

        } else {
            System.out.println("不存在");
        }
    }

    private static void scannMethod1(Map<String, Integer> map, Scanner scanner) {
        x:
//        while (scanner.hasNext()) {
        while (true) {
            String string = scanner.next();
            System.out.print(string + " ");
            String nextLine = scanner.nextLine();
            System.out.println("nextLine " + nextLine);

            getMap(map, string);

            Set<String> strings1 = map.keySet();
            //实验结果 会少一个 scanner.hasNext()出现停止的状态
            System.out.println("Scanner.hasNext() " + scanner.hasNext());
//            System.out.println("Scanner.hasNext() " + scanner.hasNext(" "));
            //何时暂停遍历呢？
            if (strings1 != null && strings1.size() == 2 && (!scanner.hasNext(" "))) {
                System.out.println("stop---------");
                break x;
            }
        }
    }

    private static void getMap(Map<String, Integer> map, String string) {
        //先获取
        Integer integer = map.get(string);
        if (integer == null) {
            map.put(string, 1);
        } else {
            map.put(string, integer + 1);
        }
    }
}

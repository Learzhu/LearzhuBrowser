package com.learzhu.browser.test.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/12 21:21
 * @update Learzhu 2017/8/12 21:21
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class TestRevert {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个整数n(2<=n<=2*10^5),表示序列的长度");
        while (true) {
            int b = in.nextInt(); //接收整形数据
            if (b >= 2 && b <= (2 * 10 ^ 5)) {
                System.out.println("n = " + b);
                //准备原始数据
                System.out.println("请输入n个整数a_i (1<=a_i<=10^9)，以空格分割");
                int[] a = new int[b];

                x:
                while (in.hasNext()) {
                    for (int j = 0; j < b; j++) {
                        int i = in.nextInt();
                        a[j] = i;
                        System.out.println("j: " + j + " b=" + b);
                        if (j == b - 1) {
//                            break;
                            break x;
                        }
                    }
                }

                //输出结果
                System.out.println("输出结果");
                for (int y :
                        a) {
                    System.out.print("y " + y);
                }

                System.out.println();

                //保存列表
                List<Integer> list = new ArrayList();
                for (int i = 0; i < b; i++) {
                    list.add(i, a[i]);
                    Collections.reverse(list);
                    System.out.print("第" + i + "次 ");
                    for (int j = 0; j < list.size(); j++) {
                        System.out.print(list.get(j) + " ");
                    }
                    System.out.println();
                }

                System.out.println("最终结果：");
//                for (int i = 0; i < a.length; i++) {
//                    System.out.print(a[i] + " ");
//                }
                for (int m :
                        list) {
                    System.out.print(m + " ");
                }
            } else {
                System.out.println("请重新输入");
            }
        }
    }
}

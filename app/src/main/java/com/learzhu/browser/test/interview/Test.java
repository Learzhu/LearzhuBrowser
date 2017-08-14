package com.learzhu.browser.test.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/12 19:44
 * @update Learzhu 2017/8/12 19:44
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class Test {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); //使用Scanner类定义对象
        System.out.println("请输入一个整数n(2<=n<=2*10^5),表示序列的长度");
//        float a = in.nextFloat(); //接收float型数据
        while (true) {
            int b = in.nextInt(); //接收整形数据
            if (b >= 2 && b <= (2 * 10 ^ 5)) {
                System.out.println("n = " + b);
                //准备原始数据
                System.out.println("请输入n个整数a_i (1<=a_i<=10^9)，以空格分割");
                int[] a = new int[b];

                x:
                while (in.hasNext()) {
//                    System.out.println("i " + i);
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
//                for (int i = 0; i < a.length; i++) {
//                    System.out.print(a[i] + " ");
//                }
//                System.out.println();

                for (int y :
                        a) {
                    System.out.println("y " + y);
                }

                System.out.println();

                //保存列表
                List<Integer> list = new ArrayList();
                for (int i = 0; i < b; i++) {
                    list.add(i, a[i]);
                    Collections.reverse(list);
                }

                System.out.println("最终结果：");
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i] + " ");
                }

//                for (int z :
//                        list) {
//                    System.out.print(z + " ");
//                }
//                String nextLine = in.nextLine();
//                System.out.println(" nextLine "+nextLine);
//                if (nextLine != null && nextLine.length() > 0) {
//                    String[] split = nextLine.split(" ");
//                    if (split != null && split.length > 0) {
//                    for (int i = 0; i < a.length; i++) {
//                        a[i] = Integer.parseInt(split[i]);
//                    }
//                    }
//                }
//                for (int y :
//                        a) {
//                    System.out.println("y " + y);
//                }
//                break;
            } else {
                System.out.println("请重新输入");
            }
        }


//        System.out.println("please input a integer number");
//        System.out.println(b);

//        test();
//        test1();
    }

    private static void test() {
        int a;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                a = input.nextInt();
                if (a < 2) {
                    break;
                }
//                break;
            } catch (Exception e) {
                System.out.println("erro is a,请重新输入：");

            }
        }
    }


    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字: ");
        for (int i = 1; i > 0; i++) {
            int inputedNumber = scanner.nextInt();
            if (inputedNumber % 2 != 0) {
                System.out.println("输入的是为奇数");
                return;
            } else {
                System.out.print("请重新输入数字: ");
            }
        }
    }
}

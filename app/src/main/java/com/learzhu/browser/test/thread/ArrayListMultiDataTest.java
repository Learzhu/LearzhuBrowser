package com.learzhu.browser.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/9 9:28
 * @update Learzhu 2017/8/9 9:28
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ArrayListMultiDataTest {
    /*作者：汪先生
    链接：https://www.zhihu.com/question/54852975/answer/141529546
    来源：知乎
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        testNormalAdd();
        System.out.println();
        testArrayListAdd();
    }

    private static void testNormalAdd() {
        long start1 = System.currentTimeMillis();
        int a = add(1);
        long end1 = System.currentTimeMillis();
        System.out.print("1 耗时：" + (end1 - start1) + "\n");

        long start2 = System.currentTimeMillis();
        int b = add(2);
        long end2 = System.currentTimeMillis();
        System.out.print("2 耗时：" + (end2 - start2) + "\n");

        long start3 = System.currentTimeMillis();
        int c = add(3);
        long end3 = System.currentTimeMillis();
        System.out.print("3 耗时：" + (end3 - start3) + "\n");
    }

    /**
     * 大部分的耗时都是因为内存担保失败引起的FullGC。
     * 1 耗时：2628
     * 2 耗时：509
     * 3 耗时：2298
     */
    private static void testArrayListAdd() {
        long start1 = System.currentTimeMillis();
        addArrayList();
        long end1 = System.currentTimeMillis();
        System.out.print("1 耗时：" + (end1 - start1) + "\n");

        long start2 = System.currentTimeMillis();
        addArrayList();
        long end2 = System.currentTimeMillis();
        System.out.print("2 耗时：" + (end2 - start2) + "\n");

        long start3 = System.currentTimeMillis();
        addArrayList();
        long end3 = System.currentTimeMillis();
        System.out.print("3 耗时：" + (end3 - start3) + "\n");
    }

    private static List addArrayList() {
        List list = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
//            a += 2;
            list.add(i);
        }
        return list;
    }

    private static int add(int a) {
        for (int i = 0; i < 10000000; i++) {
            a += 2;
        }
        return a;
    }
}

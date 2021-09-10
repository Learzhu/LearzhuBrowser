package com.learzhu.browser.test;

import java.text.DecimalFormat;

/**
 * DecimalFormatTest.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2021/7/6 17:20
 * @update Learzhu 2021/7/6 17:20
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class DecimalFormatTest {
    public static void main(String args[]) {
//        System.out.println(new DecimalFormat("0.00%").format(0.5));
//        String filePath = "A/B/11111.jpg";
//        System.out.println(System.nanoTime() +"/"+ filePath.substring(filePath.lastIndexOf(".")));
//        System.out.println(String.format(new DecimalFormat("0.00%").format((0))));;
        double percent = (double) 0 / 5;
        String percentString = new DecimalFormat("0.00%").format(1);
        System.out.println(percentString);
    }
}

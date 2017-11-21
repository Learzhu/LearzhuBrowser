package com.learzhu.browser.test;

/**
 * TestConvert.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2017/10/26 16:18
 * @update Learzhu 2017/10/26 16:18
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class TestConvert {
    // 将字母转换成数字_1
    public static String t1(String input) {
        String reg = "[a-zA-Z]";
        StringBuffer strBuf = new StringBuffer();
        input = input.toLowerCase();
        if (null != input && !"".equals(input)) {
            for (char c : input.toCharArray()) {
                if (String.valueOf(c).matches(reg)) {
                    strBuf.append(c - 96);
                } else {
                    strBuf.append(c);
                }
            }
            return strBuf.toString();
        } else {
            return input;
        }
    }

    // 将字母转换成数字
    public static void letterToNum(String input) {
        for (byte b : input.getBytes()) {
            System.out.print(b - 96);
        }
    }

    // 将数字转换成字母
    public static void numToLetter(String input) {
        for (byte b : input.getBytes()) {
            System.out.print((char) (b + 48));
        }
    }

    public static void main(String[] args) {
        String i1 = "abcdef";
        String i2 = "123456";
        letterToNum(i1);
        System.out.println();
        numToLetter(i2);
        System.out.println((char) (65));
    }
}

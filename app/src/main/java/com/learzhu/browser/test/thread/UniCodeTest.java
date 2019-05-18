package com.learzhu.browser.test.thread;

import java.io.UnsupportedEncodingException;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/9/2 16:32
 * @update Learzhu 2017/9/2 16:32
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class UniCodeTest {
    public static void main(String args[]) {
//        String s = new String("utf-8");
//        String 我 = getutf8FromString("我 1");
//        System.out.println(我);
//        String s = getutf8FromString("我");
        String s = getutf8FromString("1");
        System.out.println(s);
        System.out.println(s.getBytes().length);
    }

    /**
     * ＠class  : Jmetthod
     *
     * @param str：传入的字符串可以包含子母和汉子 ＠return :返回值为获取的字符串的utf编码
     */
    public static String getutf8FromString(String str) {
        StringBuffer utfcode = new StringBuffer();
        try {
            for (byte bit : str.getBytes("utf-8")) {
                char hex = (char) (bit & 0xFF);
                utfcode.append(Integer.toHexString(hex));
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utfcode.toString();
    }
}

package com.learzhu.browser.test;

import android.util.Log;

import com.learzhu.browser.utils.MD5Util;
import com.learzhu.browser.utils.Md5Utils;

import java.io.UnsupportedEncodingException;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/6 16:37
 * @update Learzhu 2017/3/6 16:37
 * @updateDes
 */
public class MD5Test {
    static String mString = "ABCDEFG";
    private static final String TAG = "MD5Test";

    public static void main(String args[]) {
        System.out.println("main: mString" + mString);
        String s = Md5Utils.MD5Encode(mString, "UTF-8", true);
//        LogTest.i(TAG, "main: result " + s);
        System.out.println("main: result " + s);
        try {
            String s1 = MD5Util.parseToMd5String(mString);
            System.out.println("MD5Util.parseToMd5String " + s1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

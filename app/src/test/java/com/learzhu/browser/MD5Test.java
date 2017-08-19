package com.learzhu.browser;

import com.learzhu.browser.utils.Md5Utils;

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
//        Log.i(TAG, "main: mString" + mString);
        String s = Md5Utils.MD5Encode(mString, "UTF-8", true);
//        Log.i(TAG, "main: result " + s);
    }
}

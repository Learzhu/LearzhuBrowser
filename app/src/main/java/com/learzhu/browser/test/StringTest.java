package com.learzhu.browser.test;

import com.learzhu.browser.utils.StringUtils;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/5/18 13:58
 * @update Learzhu 2017/5/18 13:58
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class StringTest {
    static String str = "  我是中国人";

    public static void main(String args[]) {
        //替换空格之后
        System.out.println("++++++" + StringUtils.formatContent(str));
    }
}

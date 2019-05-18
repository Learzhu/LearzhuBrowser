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
    static String str1 = "A我是中国人";
    static String str2 = "A";
    static String str4 = "F:\\BaiduNetdiskDownload\\android-7.1.0_r1.7z: 无法打开 E:\\Android\\AOSP\\android-7.1.0_r1\\android-7.1.0_r1\\prebuilts\\eclipse\\mavenplugins\\tycho\\tycho-dependencies-m2repo\\org\\eclipse\\tycho\\tycho-bundles-external\\0.20.0\\eclipse\\plugins\\org.eclipse.core.runtime.compatibility.registry_3.5.200.v20130514-1256\\.api_description\n" +
            "!   系统找不到指定的路径。\n";
    static String str5 = "E:\\Android\\AOSP\\android-7.1.0_r1\\android-7.1.0_r1\\prebuilts\\eclipse\\mavenplugins\\tycho\\tycho-dependencies-m2repo\\org\\eclipse\\tycho\\tycho-bundles-external\\0.20.0\\eclipse\\plugins\\org.eclipse.core.runtime.compatibility.registry_3.5.200.v20130514-1256\\.api_description\n";

    public static void main(String args[]) {
        //替换空格之后
        System.out.println("++++++" + StringUtils.formatContent(str));
        System.out.println(str1.concat("A"));
        System.out.println(str1.contains("A"));
        System.out.println(str2.contains("AA"));
        System.out.println("str4 length "+str4.length() );
        System.out.println("str5 length "+str5.length() );
    }
}

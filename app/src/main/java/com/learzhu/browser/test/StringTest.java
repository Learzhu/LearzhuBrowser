package com.learzhu.browser.test;

import com.learzhu.browser.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;

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
    static String str3 = "{\n" +
            "   \"message\" : \"查询失败\",\n" +
            "   \"result\" : false,\n" +
            "   \"returnCode\" : \"500\"\n" +
            "}";

    static String filePath = "/storage/emulated/0/Tencent/QQfile_recv/客服头像@3X.png";
    /**
     * result : false
     * returnCode : 500
     * message : 查询失败
     */

    private boolean result;
    private String returnCode;
    private String message;
    static String str4 = "F:\\BaiduNetdiskDownload\\android-7.1.0_r1.7z: 无法打开 E:\\Android\\AOSP\\android-7.1.0_r1\\android-7.1.0_r1\\prebuilts\\eclipse\\mavenplugins\\tycho\\tycho-dependencies-m2repo\\org\\eclipse\\tycho\\tycho-bundles-external\\0.20.0\\eclipse\\plugins\\org.eclipse.core.runtime.compatibility.registry_3.5.200.v20130514-1256\\.api_description\n" +
            "!   系统找不到指定的路径。\n";
    static String str5 = "E:\\Android\\AOSP\\android-7.1.0_r1\\android-7.1.0_r1\\prebuilts\\eclipse\\mavenplugins\\tycho\\tycho-dependencies-m2repo\\org\\eclipse\\tycho\\tycho-bundles-external\\0.20.0\\eclipse\\plugins\\org.eclipse.core.runtime.compatibility.registry_3.5.200.v20130514-1256\\.api_description\n";

    public static void main(String args[]) {
//        System.out.println(StringUtils.getNumberList("今天买了300个30元的59"));
        ArrayList<String> list = new ArrayList<>();
        list.add("1111");
        list.add("1111");
//        list.add("1111111111111111111111嘉兴中山店");
//        list.add("20海盐海兴东路店");
//        list.add("海宁12二院店");
//        list.add("海宁2康华医院店");
//        list.add("01");
//        list.add("1");
//        list.add("10");
//        list.add("111111嘉兴中山店");
//        list.add("000001嘉兴中山店");
//        list.add("#12当");
//        list.add("@12当");
//        list.add("中国12当");
//        list.add("中国2当");
//        list.add("12");
//        list.add("a");
//        list.add("2");
//        list.add("b");
        Collections.sort(list, StringUtils.naturalOrdering());
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return StringUtils.compareNumericalString(o1, o2);
//            }
//        });
        for (String string : list) {
            System.out.println(string);
        }


        String ss = "2.食品拆封后未封口保存，存放于冰箱的食品裸露或五常盒未加盖保存                            3.按";
        System.out.println(ss.contains("\n"));
        testSplit1();
        //替换空格之后
        System.out.println("++++++" + StringUtils.formatContent(str));
        System.out.println(str1.concat("A"));
        System.out.println(str1.contains("A"));
        System.out.println(str2.contains("AA"));
        System.out.println("-------------------");
        if ("1".equals(1)) {
            System.out.println("success000000");
        }
        System.out.println(str3.contains("查询失败"));
        System.out.println(str4.toUpperCase());
        System.out.println(testFilePath(filePath));
        testEqual();
        System.out.println(AA.class.getName());
//        testEqual1(null);
        testSplit();
        testRemoveComma();
        testFilePathPostfix();
        System.out.println("surfux: " + isAvailableImgSuffix("jpg.a"));
    }

    private static void testSplit1() {
        System.out.println("testSplit1:");
        String string = "!!!!\n888";

    }

    private static void testFilePathPostfix() {
        String test = "jpg、jpeg、gif、png、bmp";
        System.out.println(test + "\n" + "jpg:contains:" + test.contains("jpg") + "jpeg:contains:" + test.contains("jpeg")
                + "gif:contains:" + test.contains("gif") + "bmp:contains:" + test.contains("bmp"));
    }

    private static void testRemoveComma() {
        String s1 = "";
        String s2 = "AAAA,";
        String s3 = "AAAA,BBBB";
        System.out.println("testREmoveComma \n" + removeLlastComma(s1) + "\n" + removeLlastComma(s2) + "\n" + removeLlastComma(s3));
    }

    private static void testSplit() {
        String string = "http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKv70k5kDVSLbwibibLsdYUUO8OcUm5gic08V2CWkZgD2KP1iaqm5sXvbHqDAusXSuaic990jvESbPEvSQ/0";
        String[] split = string.split(",");
        System.out.println(split.length);
    }

    private static void testEqual1(String string) {
        System.out.println(string.equals(null));
        System.out.println(string == null);
    }

    private static void testEqual() {
        String money1 = "￥";
        String money2 = "¥";
        System.out.println("money test: " + money1 + " " + money2 + money1.equals(money2));
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String testFilePath(String filePath) {
        String[] split = splitPoint(filePath);
        //避免URL 的特殊字符重新取名
        StringBuilder fileName = new StringBuilder();
        if (split != null && split.length > 1) {
            fileName.append("AA").append("avatar.").append(split[1]);
        } else {
            fileName.append("BB").append("avatar.jpg");
        }
        return String.valueOf(fileName);
    }

    /**
     * @param string 待分割的字符串
     * @return
     */
    public static String[] splitPoint(String string) {
        return string.split("\\.");
    }

    class AA {
    }

    /**
     * 去除最后的逗号
     *
     * @param string 待处理的字符串
     * @return
     */
    public static String removeLlastComma(String string) {
        if (string == null || string.equals("")) {
            return "";
        }
        //去除最后一个","
        if (string.endsWith(",")) {
            return string.substring(0, string.length() - 1);
        } else {
            return string;
        }
    }

    /**
     * 微信的头像是没有后缀名的 容联云必须要求上传  jpg、jpeg、gif、png、bmp支持这几种的，
     * 判断是否是微信的没有后缀名的图片
     *
     * @param absolutePath 图片文件的绝对路径
     * @return
     */
    public static boolean isAvailableImgSuffix(String absolutePath) {
        System.out.println("str4 length " + str4.length());
        System.out.println("str5 length " + str5.length());
        return absolutePath.contains("jpg") || absolutePath.contains("jpeg") || absolutePath.contains("gif") || absolutePath.contains("png") || absolutePath.contains("bmp");
    }
}

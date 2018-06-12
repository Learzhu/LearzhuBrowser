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
    static String str3 = "{\n" +
            "   \"message\" : \"查询失败\",\n" +
            "   \"result\" : false,\n" +
            "   \"returnCode\" : \"500\"\n" +
            "}";
    static String str4 = "aaasssbbbb";

    static String filePath = "/storage/emulated/0/Tencent/QQfile_recv/客服头像@3X.png";
    /**
     * result : false
     * returnCode : 500
     * message : 查询失败
     */

    private boolean result;
    private String returnCode;
    private String message;

    public static void main(String args[]) {
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
        testEqual1(null);
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
}

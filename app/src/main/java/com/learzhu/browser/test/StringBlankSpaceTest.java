package com.learzhu.browser.test;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/5/31 23:25
 * @update Learzhu 2017/5/31 23:25
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class StringBlankSpaceTest {

    private static String testString = "　　　　这个时代，人活着很不容易，易云对此深有体会，但是他从未想过，自己还是大好年华的时候，会有这么一天，真的就这么要死了。\n" +
            "　　今天早晨，易云约了两个好友爬山，其中还有一个漂亮的妹子，这自然是很美好的事情。\n" +
            "　　年轻人总是喜欢刺激，易云也是，中规中矩的去爬那些被人为开发的旅游山没什么意思，他们就选择了一座人迹罕至的荒山。\n" +
            "　　爬到荒山的半山腰，他们发现了一个山洞。";

    public static void main(String args[]) {
        System.out.println("1. String.trim() " + testString.trim());
        System.out.println("2. str.replace(\" \", \"\"); " + testString.replace(" ", ""));
        System.out.println("3. replaceAll(\" +\",\"\")" + testString.replaceAll(" +", ""));
        System.out.println("4. str = .replaceAll(\"\\\\s*\", \"\")" + testString.replaceAll("\\s*", ""));
        System.out.println("5. remove(String resource, char ch)" + remove(testString, (char) (12288)));
        System.out.println("6. removeBlank(String testString)" + removeBlank(testString));
    }

    public static String removeBlank(String testString) {
        testString = testString.trim();
        //中文空格从上文复制
        testString = testString.replaceAll("　", "");
        //中文空格自己打 发现无效
        testString = testString.replaceAll(" ", "");
        //制表符
        testString = testString.replaceAll("    ", "");
        //英文空格
        testString = testString.replaceAll(" ", "");
        //可以替换大部分空白字符， 不限于空格 \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
        testString = testString.replaceAll("\\s*", "");
        return testString;
    }

    public static String remove(String resource, char ch) {
        StringBuffer buffer = new StringBuffer();
        int position = 0;
        char currentChar;
        while (position < resource.length()) {
            currentChar = resource.charAt(position++);
            if (currentChar != ch) buffer.append(currentChar);
        }
        return buffer.toString();
    }
}

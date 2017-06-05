package com.learzhu.browser.test;

import static com.learzhu.browser.utils.StringUtils.getTwoSpaces;

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

    private static String testString1 = "“当然算数，不过考中童生太难。”方运无奈地说。\n" +
            "　　“我相信我们家小运一定能！不仅能当童生，一定还能中秀才，说不定能当上举人老爷！”\n" +
            "　　方运微微一愣，才反应过来，杨玉环这不是在没话找话，是听到他刚才叹气，故意开解他。\n" +
            "　　方运不能让她担心，笑道：“如果我能中童生，那一定是玉环姐的功劳，到了那时候，我一定把玉环姐供起来，天天让你好吃好喝，然后让你天天说我能中秀才。等中了秀才，就让你天天说我能中举人！”\n" +
            "　　杨玉环忍不住轻声笑起来，露出洁白的牙齿。\n" +
            "　　“小运，你好像变了个人似的。”杨玉环看着方运，隐隐有些担忧。\n" +
            "　　\n" +
            "　　";

    private static String testString2 = "“小运，你好像变了个人似的。”杨玉环看着方运，隐隐有些担忧。\n" +
            "　　\n" +
            "　　";

    public static void main(String args[]) {
        System.out.println("1. String.trim() " + testString.trim());
        System.out.println("2. str.replace(\" \", \"\"); " + testString.replace(" ", ""));
        System.out.println("3. replaceAll(\" +\",\"\")" + testString.replaceAll(" +", ""));
        System.out.println("4. str = .replaceAll(\"\\\\s*\", \"\")" + testString.replaceAll("\\s*", ""));
        System.out.println("5. remove(String resource, char ch)" + remove(testString, (char) (12288)));
        System.out.println("6. removeBlank(String testString)" + removeBlank(testString));
        System.out.println("7. formatContent(String testString)" + formatContent(testString2));
    }

    public static String formatContent(String str) {
        str = str.replaceAll("[ ]*", "");//替换来自服务器上的，特殊空格
        str = str.replaceAll("[ ]*", "");//
        str = str.replaceAll("　", "");
        str = str.replaceAll((char) 12288 + "", "");
        str = str.replace("\n\n", "\n");
        //替换中文的空格
        //每段换行空两格
        str = str.replace("\n", "\n" + getTwoSpaces());
        //整章开始空两格
        str = getTwoSpaces() + str;
//        str = convertToSBC(str);
        //去除最后的换行和空格
        if (str.lastIndexOf("\n"+getTwoSpaces())==str.length()-3&&str.length()>3) {
            str = str.substring(0, str.length() - 3);
        }
        return str;
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

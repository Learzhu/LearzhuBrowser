/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.learzhu.browser.utils;

import android.text.TextUtils;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lfh on 2016/9/10.
 */
public class StringUtils {
    public static String SEPARATOR = "ÿ";

    public static String creatAcacheKey(Object... param) {
        String key = "";
        for (Object o : param) {
            key += "-" + o;
        }
        return key.replaceFirst("-", "");
    }

    /**
     * 格式化小说内容。
     * <p/>
     * <li>小说的开头，缩进2格。在开始位置，加入2格空格。
     * <li>所有的段落，缩进2格。所有的\n,替换为2格空格。
     *
     * @param str
     * @return
     */
    public static String formatContent(String str) {
        str = str.replaceAll("[ ]*", "");//替换来自服务器上的，特殊空格
        str = str.replaceAll("[ ]*", "");//替换来自服务器上的中文的空格 无效
        str = str.replaceAll("[\u3000]*", "");//替换来自服务器上的中文的空格 无效
        str = str.replaceAll("[ ]*", "");//
        str = str.replace("\n\n", "\n");
        str = str.replace("\n", "\n" + getTwoSpaces());
        str = getTwoSpaces() + str;
//        str = convertToSBC(str);
        return str;
    }

    /**
     * Return a String that only has two spaces.
     *
     * @return
     */
    public static String getTwoSpaces() {
        return "\u3000\u3000";
    }

    /**
     * @param string 待分割的字符串
     * @return
     */
    public static String[] splitPoint(String string) {
        return string.split("\\.");
    }

    /**
     * @param string 待分割的字符串
     * @return
     */
    public static String[] splitSeparator(String string) {
        return string.split(File.separator);
    }

    public static String getDateWithoutSec(String date) {
        if (date == null || date.trim().equals("")) {
            return "";
        }
        return String.valueOf(date.subSequence(0, date.lastIndexOf(":")));
    }

    public static ArrayList toStringList(String string) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(string) && string.contains(",")) {
            String[] split = string.split(",");
            if (null != split && split.length > 0) {
                for (String s : split) {
                    if (!TextUtils.isEmpty(s)) {
                        arrayList.add(s);
                    }
                }
            }
        } else if (!TextUtils.isEmpty(string)) {
            arrayList.add(string);
        }
        return arrayList;
    }

    /**
     * 截取字符串中的数字
     *
     * @param content
     * @return
     */
    public static List<String> getNumberList(String content) {
        List<String> numList = new ArrayList<>();
        Pattern p = Pattern.compile("\\d{1,}");
        Matcher m = p.matcher(content);
        while (m.find()) {
            numList.add(m.group());
        }
        return numList;
    }

//    public static int getResultFromIndex(int index, String string) {
//        char[] chars = string.toCharArray();
//    }

    public static Comparator<String> naturalOrdering() {
        final Pattern compile = Pattern.compile("(\\d+)|(\\D+)");
        return (s1, s2) -> {
            final Matcher matcher1 = compile.matcher(s1);
            final Matcher matcher2 = compile.matcher(s2);
            while (true) {
                final boolean found1 = matcher1.find();
                final boolean found2 = matcher2.find();
                if (!found1 || !found2) {
                    return Boolean.compare(found1, found2);
                } else if (!matcher1.group().equals(matcher2.group())) {
                    if (matcher1.group(1) == null || matcher2.group(1) == null) {
                        return matcher1.group().compareTo(matcher2.group());
                    } else {
//                        return Integer.valueOf(matcher1.group(1)).compareTo(Integer.valueOf(matcher2.group(1)));
//                        return matcher1.group(1).compareTo(matcher2.group(1));
                        return new BigInteger(matcher1.group(1)).compareTo(new BigInteger(matcher2.group(1)));
                    }
                }
            }
        };
    }

    private static final boolean isDigit(char ch) {
        return ch >= 48 && ch <= 57;
    }

    public static int compareNumericalString(String s1, String s2) {
        int s1Counter = 0;
        int s2Counter = 0;
        while (true) {
            if (s1Counter >= s1.length()) {
                break;
            }
            if (s2Counter >= s2.length()) {
                break;
            }
            char currentChar1 = s1.charAt(s1Counter++);
            char currentChar2 = s2.charAt(s2Counter++);
            if (isDigit(currentChar1) && isDigit(currentChar2)) {
                String digitString1 = "" + currentChar1;
                String digitString2 = "" + currentChar2;
                while (true) {
                    if (s1Counter >= s1.length()) {
                        break;
                    }
                    if (s2Counter >= s2.length()) {
                        break;
                    }

                    if (isDigit(s1.charAt(s1Counter))) {
                        digitString1 += s1.charAt(s1Counter);
                        s1Counter++;
                    }

                    if (isDigit(s2.charAt(s2Counter))) {
                        digitString2 += s2.charAt(s2Counter);
                        s2Counter++;
                    }

                    if ((!isDigit(s1.charAt(s1Counter))) && (!isDigit(s2.charAt(s2Counter)))) {
                        currentChar1 = s1.charAt(s1Counter);
                        currentChar2 = s2.charAt(s2Counter);
                        break;
                    }
                }
                if (!digitString1.equals(digitString2)) {
                    return Integer.parseInt(digitString1) - Integer.parseInt(digitString2);
                }
            }

            if (currentChar1 != currentChar2) {
                return currentChar1 - currentChar2;
            }
        }
        return s1.compareTo(s2);
    }
}

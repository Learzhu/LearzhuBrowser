package com.learzhu.browser.test;

import com.learzhu.browser.utils.StringUtils;

/**
 * SpecialStringTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-05-24 20:19
 * @update Learzhu 2019-05-24 20:19
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class SpecialStringTest {
    //    public static String message1 = "01测试厂家686ÿ2ÿhttp://yzh-img-test.oss-cn-hangzhou.aliyuncs.com/goods/attr/20190514/48.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350ÿ4059d066762311e9943200163e101d35ÿ9415435275ea11e9943200163e101d35ÿ0ÿ1";
    public static String message1 = "01测试厂家686/n2/nhttp://yzh-img-test.oss-cn-hangzhou.aliyuncs.com/goods/attr/20190514/48.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/n4059d066762311e9943200163e101d35/n9415435275ea11e9943200163e101d35/n0/n1";

    public static void main(String args[]) {
        showInfo();
    }

    public static void showInfo() {
        String[] split = message1.split(StringUtils.SEPARATOR);
        String[] split1 = message1.split("/n");
        String[] split2 = message1.split(",");
        if (split.length > 2) {
            System.out.println("1111");
        } else if (split1.length > 2) {
            System.out.println("22222");
        } else if (split2.length > 2) {
            System.out.println("333");
        } else {
            System.out.println("4444");
        }

    }
}

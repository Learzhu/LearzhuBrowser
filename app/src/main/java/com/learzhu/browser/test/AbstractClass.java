package com.learzhu.browser.test;

import static com.learzhu.browser.test.Constants.BASE_SERVER;
import static com.learzhu.browser.test.Constants.PRODUCE_SERVER;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/4/11 21:59
 * @update Learzhu 2017/4/11 21:59
 * @updateDes
 */

public abstract class AbstractClass {

    public static String PUSHTAG = getString();

    public static String getString() {
        if (BASE_SERVER.equals(PRODUCE_SERVER)) {
            return "PRODUCE_SERVER";
        } else {
            return "DEVELOP_SERVER";
        }
    }

    public static void main(String args[]) {
//        String string = getString();
        System.out.println(PUSHTAG);
    }
}

package com.learzhu.browser.test;

/**
 * TestTimeMillis.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 1.8.2.0 2021/10/28 14:19
 * @update Learzhu 2021/10/28 14:19
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class TestTimeMillis {
    public static void main(String args[]) {
        long before = System.currentTimeMillis();
        System.out.println(before);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - before);
    }
}

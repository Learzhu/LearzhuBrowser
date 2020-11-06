package com.learzhu.browser.test;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/5 19:07
 * @update Learzhu 2017/8/5 19:07
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ConstrorTest {

    A mA;

    public ConstrorTest(A a) {
        mA = a;
    }

    public ConstrorTest() {
        mA = new A(2);
    }
}

class A {
    int x;

    public A(int x) {
        this.x = x;
    }
}
package com.learzhu.browser.test.singleton;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/6/28 18:25
 * @update Learzhu 2017/6/28 18:25
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

/**
 * 方法二
 * 单例模式的实现：饱汉式,非线程安全
 */
public class Singleton {

    // 定义私有构造方法（防止通过 new SingletonTest()去实例化）
    private Singleton() {
    }

    // 定义一个SingletonTest类型的变量（不初始化，注意这里没有使用final关键字）
    private static Singleton instance;

    // 定义一个静态的方法（调用时再初始化SingletonTest，但是多线程访问时，可能造成重复初始化问题）
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
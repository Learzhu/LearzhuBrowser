package com.learzhu.browser.test.singleton;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/6/28 18:24
 * @update Learzhu 2017/6/28 18:24
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

/**
 * 方法三
 * 单例模式的实现：饱汉式,线程安全简单实现
 */
public class SingletonTest {

    // 定义私有构造方法（防止通过 new SingletonTest()去实例化）
    private SingletonTest() {
    }

    // 定义一个SingletonTest类型的变量（不初始化，注意这里没有使用final关键字）
    private static SingletonTest instance;

    // 定义一个静态的方法（调用时再初始化SingletonTest，使用synchronized 避免多线程访问时，可能造成重的复初始化问题）
    public static synchronized SingletonTest getInstance() {
        if (instance == null)
            instance = new SingletonTest();
        return instance;
    }
}

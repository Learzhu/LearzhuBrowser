package com.learzhu.browser.test.singleton;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/6/28 18:26
 * @update Learzhu 2017/6/28 18:26
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

/**
 * 方法一
 * 单例模式的实现：饿汉式,线程安全 但效率比较低
 */
public class SingletonSimple {

    // 定义一个私有的构造方法
    private SingletonSimple() {
    }

    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final SingletonSimple instance = new SingletonSimple();

    // 静态方法返回该类的实例
    public static SingletonSimple getInstance() {
        return instance;
    }

}
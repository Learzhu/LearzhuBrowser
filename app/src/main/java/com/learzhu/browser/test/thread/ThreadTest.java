package com.learzhu.browser.test.thread;

import java.util.concurrent.Executors;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/5 17:15
 * @update Learzhu 2017/8/5 17:15
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ThreadTest {
    public static void main(String args[]) {
        //创建定长线程池
        Executors executors = (Executors) Executors.newFixedThreadPool(5);
        //创建可缓存的线程池
        Executors executors1 = (Executors) Executors.newCachedThreadPool();
        //创建定长的线程池
        Executors executors2 = (Executors) Executors.newScheduledThreadPool(5);
        //创建定长的线程池
        Executors executors3 = (Executors) Executors.newSingleThreadExecutor();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5);
    }

}

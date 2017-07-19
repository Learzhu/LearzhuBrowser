package com.learzhu.browser.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/18 19:00
 * @update Learzhu 2017/7/18 19:00
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ExecutorsTest {
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}

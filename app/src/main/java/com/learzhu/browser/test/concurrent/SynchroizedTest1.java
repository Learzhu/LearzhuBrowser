package com.learzhu.browser.test.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * SynchroizedTest1.java是LearzhuBrowser的使用同步的类。
 *
 * @author Learzhu
 * @version 1.0.0 2020-03-01 15:59
 * @use
 * @update UserName 2020-03-01 15:59
 * @updateDes
 */
public class SynchroizedTest1 {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String args[]) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}

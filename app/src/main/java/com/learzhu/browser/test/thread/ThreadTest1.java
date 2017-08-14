package com.learzhu.browser.test.thread;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/8/11 15:18
 * @update Learzhu 2017/8/11 15:18
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class ThreadTest1 {
    private int j;

    public static void main(String args[]) {
        ThreadTest1 tt = new ThreadTest1();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}

//----------随手再写的一个-------------

//class A {
//    JManger j = new JManager();
//
//    main() {
//        new A().call();
//    }
//
//    void call() {
//        for (int i = 0; i < 2; i++) {
//            new Thread(
//                    new Runnable() {
//                        public void run() {
//                            while (true) {
//                                j.accumulate();
//                            }
//                        }
//                    }
//            ).start();
//            new Thread(new Runnable() {
//                public void run() {
//                    while (true) {
//                        j.sub();
//                    }
//                }
//            }).start();
//        }
//    }
//}
//
//class JManager {
//    private int j = 0;
//
//    public synchronized void subtract() {
//        j--;
//    }
//
//    public synchronized void accumulate() {
//        j++;
//    }
//}

/*
作者：马伟奇
        链接：http://www.jianshu.com/p/fb6e5bfd34cc
        來源：简书
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

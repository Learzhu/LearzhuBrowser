package com.learzhu.browser.test.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/12 19:36
 * @update Learzhu 2017/7/12 19:36
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class JsoupTest {
    public static void main(String args[]) {
        String url = "http://read.qidian.com/chapter/s38Lp4KdkZxH9vdK3C5yvw2/4iZ3_0ljIYO2uJcMpdsVgA2";
        //方法一 直接用Jsoup
        Connection connect = Jsoup.connect(url);
        System.out.println("connect: " + connect);
        try {
            Document document = connect.get();
            System.out.println("Document: " + document);
//            System.out.println("Document: toString " + document.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //以下两个会出现异常 Exception in thread "main" java.lang.RuntimeException: Stub!
       /* 起因：Android开发时，想执行类中的main()方法。
        原因：当你导入了android的SDK时，程序入口优先为Android的Activity.
                解决办法：
        1、选中项目，右键 -> Run As -> Run Configurations...
        2、在Java Aplication(或你对应的分类)中找到你刚运行的项目，没有的话可以手动创建或运行一次该类即可；
        3、切换到Classpath选项栏，删掉Bootstrap Entries里面的Android Library，然后点击右侧的Advanced.. -> Add Library -> JRE System Library，一路next即可。


        另外：去掉Android.jar包，程序中用到的jar包单独导入。再试试。

        参考连接：http://univasity.iteye.com/blog/1067127*/

//        //方法二：用Http请求
//        String s = HttpRequestUtil.sendAndGetStringByHttpClient(url);
//        System.out.println("sendAndGetStringByHttpClient : " + s);
//
//        //方法三：用Http请求
//        String result = HttpRequestUtil.sendAndGetStringByHttpUrlConnection(url);
//        System.out.println("sendAndGetStringByHttpUrlConnection : " + result);


    }
}

package com.learzhu.browser.test.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/11 16:55
 * @update Learzhu 2017/7/11 16:55
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class JsonTest {
    public static void main(String args[]) {
        System.out.println("start: " + System.currentTimeMillis());
        List<ChapterBean> list = new ArrayList<>();
        //新建对象放到集合中
//        for (int i = 0; i < 1000000; i++) {
        for (int i = 0; i < 1000; i++) {
            ChapterBean chapterBean = new ChapterBean();
            chapterBean.chapterId = i;
            list.add(chapterBean);
        }
        String string = null;
        System.out.println("start: transform list to json start " + System.currentTimeMillis());
        try {
            string = JacksonJsonUtil.pojo2json(list);
            System.out.println("result : " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("start: transform list to json end" + System.currentTimeMillis());
        System.out.println("start: transform json to list start" + System.currentTimeMillis());

        try {
            ArrayList<ChapterBean> chapterBeenList = JacksonJsonUtil.json2pojoList(string, ChapterBean.class);
            System.out.println("start: transform json to list end" + System.currentTimeMillis());
            for (ChapterBean chapterBean :
                    chapterBeenList) {
                if (chapterBean.chapterId == 500) {
                    break;
                }
            }
            System.out.println("getBean success " + System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

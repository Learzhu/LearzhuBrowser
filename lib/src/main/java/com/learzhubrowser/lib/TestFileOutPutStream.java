package com.learzhubrowser.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * TestFileOutPutStream.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 2020/11/3 10:31
 * @update Learzhu 2020/11/3 10:31
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class TestFileOutPutStream {
    public static void main(String args[]) {
        String filePath = "E:\\JavaProject\\A.txt";
//        File file = new File(filePath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

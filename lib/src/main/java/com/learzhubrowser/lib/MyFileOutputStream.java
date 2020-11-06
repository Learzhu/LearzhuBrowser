package com.learzhubrowser.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * MyFileOutputStream.java是LearzhuBrowser的类。
 *
 * @author learzhu
 * @version 2020/11/3 10:36
 * @update Learzhu 2020/11/3 10:36
 * @updateDes
 * @include {@link }
 * @used {@link }
 * @goto {@link }
 */
public class MyFileOutputStream extends FileOutputStream {
    public MyFileOutputStream(String s) throws FileNotFoundException {
        super(s);
    }

    @Override
    public void write(int i) throws IOException {
        super.write(i);
    }
}

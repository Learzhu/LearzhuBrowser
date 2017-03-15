package com.learzhu.browser;

import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/2/24 17:01
 * @update Learzhu 2017/2/24 17:01
 * @updateDes 测试对象是否为空的类
 */
public class JavaNullTest {
    public static void main(String args[]) {
        Collection collection = new Collection();
        collection.setString("AA");
        System.out.println("List" + collection.getList());
        System.out.println("String" + collection.getString());
    }
}

class Collection {
    private List<String> mList;
    private String mString;

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }
}

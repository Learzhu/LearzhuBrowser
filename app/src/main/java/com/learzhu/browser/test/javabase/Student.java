package com.learzhu.browser.test.javabase;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/7/11 22:03
 * @update Learzhu 2017/7/11 22:03
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class Student {
    //构造方法
    public Student() {
        this.name = "郑翠";

        this.isMale = false;

        this.age = 23;

        this.favourite = "听歌、篮球";

        count++;

    }

    //构造方法重载
    public Student(String name, boolean isMale, int age, String favourite) {

        this.name = name;

        this.isMale = isMale;

        this.age = age;

        this.favourite = favourite;

        count++;

    }

    //类的属性定义

    String name; //姓名

    boolean isMale; //是否男性

    int age; //年龄

    String favourite; //爱好

    String introduction; //简介

    static int count = 0; //学生人数  静态成员

    //方法定义

    public void display() {

        System.out.println("姓名：" + name + ",性别：" + (isMale ? "男" : "女") + ",年龄：" + age + ",爱好" + favourite);

        Student.showNumber();  //成员方法调用静态方法

    }

    //对学生爱好进行过滤
    public void filter(String favourite) {
        int idx = this.favourite.indexOf(favourite);
        if (idx != -1) {
            String substr1 = this.favourite.substring(0, idx);

            String substr2 = this.favourite.substring(idx + favourite.length());

            this.favourite = substr1 + "*****" + substr2;

        }

    }

    public static void showNumber() {

        System.out.println("共有学生" + count + "人"); //count换成this.count将出错，静态方法中不能使用this

        //静态方法不能直接访问实例变量和普通方法

    }

    public static void main(String[] args) {
        Student s1 = new Student("张三", true, 22, "打篮球、打人"); //此句会调用构造方法

        s1.filter("打人");

        s1.display();

        System.out.println("简介：" + s1.introduction);

        Student.showNumber();  //静态方法调用静态方法

        Student s2 = new Student();

        s2.display();
    }

}

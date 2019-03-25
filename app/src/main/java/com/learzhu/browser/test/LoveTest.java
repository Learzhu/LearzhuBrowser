package com.learzhu.browser.test;

/**
 * LoveTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-03-22 13:31
 * @update Learzhu 2019-03-22 13:31
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class LoveTest {
    public static void main(String args[]) {
        Love learzhuLove = new Love("祝杭鹏", 80, 27);
        System.out.println(learzhuLove.toString());
        Love baekhyunLove = new Love("李晓萌", 0, 25);
        System.out.println(baekhyunLove.toString());
        System.out.println("我的对象:");
        System.out.println("李晓萌想和祝杭鹏结婚: " + ((baekhyunLove.getMarriageTime() - learzhuLove.getMarriageTime() > 0) ? "真" : "假"));
        System.out.println("祝杭鹏想和李晓萌结婚: " + (learzhuLove.getMarriageTime() - baekhyunLove.getMarriageTime() > 0 ? "真" : "假"));
        double random = Math.random();
        System.out.println(random + " " + (random > 0.5));
    }
}

class Love {
    private String name;
    private int marriageTime;
    private int age;

    public Love(String name, int marriageTime, int age) {
        this.name = name;
        this.marriageTime = marriageTime;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarriageTime() {
        return marriageTime;
    }

    public void setMarriageTime(int marriageTime) {
        this.marriageTime = marriageTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Love{" +
                "name='" + name + '\'' +
                ", marriageTime=" + marriageTime +
                ", age=" + age +
                '}';
    }
}

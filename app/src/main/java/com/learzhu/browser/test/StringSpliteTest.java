package com.learzhu.browser.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 2.2.5 2017/3/29 19:50
 * @update Learzhu 2017/3/29 19:50
 * @updateDes
 */

public class StringSpliteTest {
    private static String testString = null;
//    private static String testString = "";

    private static String testString1 = "AAAA" + File.separator + "BBB.jpg";

    public static void main(String args[]) {
//        String[] split = testString.split(",");
        //空的还1
//        System.out.println("splite---" + split.length);
//        System.out.println(testString1);
//        String[] strings = StringUtils.splitSeparator(testString1);
//        if (ArrayUtils.isAvailable(strings)) {
//            String string = strings[strings.length - 1];
//            if (ObjectUtils.isObjectNotNull(string)) {
//                String[] strings1 = StringUtils.splitPoint(string);
//
//            }
//            System.out.println(string);
//        }

//        String dateWithoutSec = StringUtils.getDateWithoutSec("2018-05-06 12:22:33");
//        String dateWithoutSec = StringUtils.getDateWithoutSec(" ");
//        System.out.println(dateWithoutSec);
        System.out.println(changeRecent("E"));
//        System.out.println(getRecentVisitCitiesStringList());
    }

    public static String changeRecent(String city) {
        String recentCities = "A,B,C,D,E,F,";
//        String recentCities = "";
//        String recentCities = "E";
        if (recentCities.isEmpty()) {
            recentCities = city;
        } else {
            String[] strings = recentCities.split(",");
            boolean isExisted = false;
            //遍历保存新的访问地址 更新历史和位置排序
            for (int i = 0; i < strings.length; i++) {
                if (city.equals(strings[i])) {
                    //如果存在就更换顺序
                    isExisted = true;
                    StringBuilder citiesSb = new StringBuilder();
                    citiesSb.append(city).append(",");
                    for (int j = 0; j < strings.length && j != i; j++) {
                        citiesSb.append(strings[j]).append(",");
                    }
                    recentCities = citiesSb.toString();
                    break;
                }
            }
            if (!isExisted) {
                //如果之前不存在的就添加到开头
                recentCities = city + "," + recentCities;
            }
        }
        return recentCities;
    }

    public static List<String> getRecentVisitCitiesStringList() {
        String recentCities = "";
        String[] split = recentCities.split(",");
        List<String> cities = new ArrayList<>();
        for (String city : split) {
            cities.add(city);
        }
        return cities;
    }

}

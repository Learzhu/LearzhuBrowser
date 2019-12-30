package com.learzhu.browser.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * PercentTest.java是液多多的类。
 *
 * @author Learzhu
 * @version 2019-12-30 13:41
 * @update Learzhu 2019-12-30 13:41
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class PercentTest {
    public static void main(String args[]) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        System.out.println(Float.parseFloat(decimalFormat.format((double) 1 / (double) 100)));
        System.out.println(decimalFormat.format((double) 1 / (double) 100));
        System.out.println(decimalFormat.format(((double) (1 / 100))));
        System.out.println(decimalFormat.format((((double) 1) / 100)));
        System.out.println((double) 1 / 100);
        System.out.println(decimalFormat.format(0.01));
//        showFormat((double) (1 / 100));
//        showFormatMore((double) (1 / 100));
    }

    /**
     * 测试各种舍入模式的不同
     *
     * @param result 待格式化的参数
     */
    private static void showFormatMore(Double result) {
        System.out.println("初始值：" + result.toString());
        DecimalFormat decimalFormat = new DecimalFormat("0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println("HALF_EVEN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("HALF_UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        System.out.println("HALF_DOWN：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("FLOOR：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        System.out.println("CEILING：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.UP);
        System.out.println("UP：" + decimalFormat.format(result));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("DOWN：" + decimalFormat.format(result));
    }

    /**
     * 打印数据遭格式化之后的效果(默认是HALF_EVEN，他不是四舍五入，)
     *
     * @param value 待格式化的参数
     */
    private static void showFormat(Double value) {
        System.out.println("初始值：" + value.toString());
        //取一位整数
        System.out.println(new DecimalFormat("0").format(value));
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(value));
        //取两位整数和三位小数，整数不足部分以0填补
        System.out.println(new DecimalFormat("00.000").format(value));
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(value));
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(value));
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(value));
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(value));
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(value));
        //将格式嵌入文本
        System.out.println(new DecimalFormat("所传入的格式化参数是：###大小。").format(value));
    }
}

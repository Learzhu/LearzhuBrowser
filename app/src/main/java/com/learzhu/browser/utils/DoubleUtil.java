package com.learzhu.browser.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * DoubleUtil.java  是液总汇的类。
 *
 * @author kk
 * @version 2.0.0 2017/9/28 17:48
 * @update kk 2017/9/28 17:48
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class DoubleUtil {

    // 默认除法运算精度
    private static final Integer DEF_DIV_SCALE = 2;

    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * @param value1
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(Number value1, Number value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param value1 被乘�?
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时�? 精确到小数点以后10位，以后的数字四舍五入�??
     *
     * @param dividend 被除�?
     * @param divisor  除数
     * @return 两个参数的商
     */
    public static Double div(Double dividend, Double divisor) {
        return div(dividend, divisor, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算�?? 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入�?
     *
     * @param dividend 被除�?
     * @param divisor  除数
     * @param scale    表示表示�?要精确到小数点以后几位�??
     * @return 两个参数的商
     */
    public static Double div(Double dividend, Double divisor, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(dividend));
        BigDecimal b2 = new BigDecimal(Double.toString(divisor));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理�?
     *
     * @param value �?要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public Double round(Double value, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(value));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String formatPrice(String price) {

        return formatPrice(DoubleUtil.parseDouble(price));
    }

    //带有正负符号的格式化
    public static String formatIntegralWithSumbol(double price) {
        String sumbol = "";
        if (price >= 0) {
            sumbol = "+";
        } else {
//            sumbol = "-";
        }
        return sumbol + (long) price;
    }

    //带有正负符号的格式化
    public static String formatPriceWithSumbol(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String sumbol = "";
        if (price >= 0) {
            sumbol = "+";
        } else {
//            sumbol = "-";
        }
        return sumbol + df.format(price);
    }

    public static String formatPriceSplitByComma(double price) {
        if (price < 1000) {
            return formatPrice(price);
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(price);
    }

    //小数点后一位
    public static String formatDoubleHave1NumAfterPoint(double value) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(value);
    }

    public static String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }

    //先绝对值 然后再两位小数
    public static String formatPriceAbs(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(Math.abs(price));
    }

    public static String formatPriceWithRMB(String price) {
        return formatPriceWithRMB(DoubleUtil.parseDouble(price));
    }

    public static String formatPriceWithRMB(double price) {
        return "¥" + formatPrice(price);
    }


    //去除科学计数法
    public static String doubleNoSCS(double d) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(d);
    }

    public static double parseDouble(String s) {
        if (!StringUtils.isEmpty(s)) {//如果不为空 并且不以点开始的话 因为输入金额的地方只能输入数字和点 所以这个判断足以
            if (!s.startsWith(".")) {
                double result = 0;
                try {
//                    result = Double.parseDouble(s) * 1.00D;
//                    result = Double.valueOf(s).doubleValue();
                    result = (double) Math.round(Double.parseDouble(s) * 100) / 100;
//                    result=  new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                    NumberFormat.getNumberInstance().format(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            } else {
//                ToastShow.showMessage("数字不能以点开始哦,请重新输入");
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 从bigDecimal的数据获取到 double的值
     *
     * @param bigDecimal
     * @return
     */
    public static double transBigDecimal2Dobule(BigDecimal bigDecimal) {
        if (ObjectUtils.isObjectNotNull(bigDecimal)) {
            return bigDecimal.doubleValue();
        } else {
            return 0.00;
        }
    }
}

package com.learzhu.browser.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Greeting.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-03-27 15:14
 * @update Learzhu 2019-03-27 15:14
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
//// 让保持性策略为运行时态，即将注解编码到class文件中，让虚拟机读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Greeting {
    public enum FontColor {
        BLUE,
        RED,
        GREEN
    }

    ;

    String name();

    FontColor fontColor() default FontColor.RED;
}

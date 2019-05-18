package com.learzhu.browser.test.annotation;

/**
 * AnnotationTest.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-03-27 15:11
 * @update Learzhu 2019-03-27 15:11
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class AnnotationTest {
    @NewAnnotation("mainmethod")
    public static void main(String args[]) {
        saying();
        sayHelloWithDefaultFontColor();
        sayHelloWithRedFontColor();
    }

    // // 此时的fontColor为默认的RED
    @Greeting(name = "defaultfontcolor")
    private static void sayHelloWithRedFontColor() {
    }

    @Greeting(name = "notdefault", fontColor = Greeting.FontColor.BLUE)
    private static void sayHelloWithDefaultFontColor() {
    }

    @NewAnnotation(value = "saymethod")
    private static void saying() {
    }
}

enum RetentionPolicy {
    // 此类型会被编译器丢弃
    SOURCE,
    // 此类型注解会保留在class文件中，但JVM会忽略它
    CLASS,
    // 此类型注解会保留在class文件中，JVM会读取它
    RUNTIME
}
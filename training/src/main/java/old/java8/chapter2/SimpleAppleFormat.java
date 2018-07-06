package old.java8.chapter2;

import old.java8.chapter2.interfaces.ApplePrintFormatter;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class SimpleAppleFormat implements ApplePrintFormatter {
    @Override
    public String accept(Apple apple) {
        return "简单的："+apple.toString();
    }
}
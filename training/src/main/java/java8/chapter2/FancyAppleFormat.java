package java8.chapter2;

import java8.chapter2.interfaces.ApplePrintFormatter;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class FancyAppleFormat implements ApplePrintFormatter {
    @Override
    public String accept(Apple apple) {
        return "重的或者清的："+apple.toString();
    }
}
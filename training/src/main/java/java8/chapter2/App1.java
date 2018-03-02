package java8.chapter2;

import java8.chapter2.interfaces.ApplePrintFormatter;

import java.util.Arrays;
import java.util.List;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class App1 {
    public static void main(String[] args) {
        List<Apple> apples= Arrays.asList(new Apple("red",15d),new Apple("red",17.5d),
                new Apple("green",25d),new Apple("red",30d),new Apple("green",21d));

        ApplePrintFormatter formatter = new SimpleAppleFormat();
        printApple(apples, formatter);

        apples.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));

    }
    public static void printApple(List<Apple> inventory,ApplePrintFormatter formatter){
        for (Apple apple : inventory) {
            System.out.println(formatter.accept(apple));
        }
    }




}




package java8.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/02/23.
 */
public class AppleDemo {
    public static void main(String[] args) {
        List<Apple> appleList= Arrays.asList(
                new Apple("red", 11.8),
                new Apple("red", 22.8),
                new Apple("green", 33.8)
        );

        List<Apple> redApples = filterApples(appleList, AppleDemo::isRedApple);
        redApples.forEach(i-> System.out.println(i));

        System.out.println("------------------------------------");

        List<Apple> heavyApples = filterApples(appleList, AppleDemo::isHeavyApple);
        heavyApples.forEach(i-> System.out.println(i));

        System.out.println("-------------------------------------");

        List<Apple> specialLBDApples = filterApples(appleList,
                (apple) -> apple.getColor().equals("red")||apple.getWeight()>15d);
        specialLBDApples.forEach(i-> System.out.println(i));

        System.out.println("-------------------------------------");

        List<Apple> collect = appleList.stream().filter(apple -> apple.getWeight() > 15d)
                .collect(Collectors.toList());
        collect.forEach(i-> System.out.println(i));

    }

    public static boolean isRedApple(Apple apple){
        return apple.getColor().equals("red");
    }
    public static boolean isHeavyApple(Apple apple){
        return  apple.getWeight().compareTo(15.0)>0;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p){
        List<Apple> list=new ArrayList<>();
        for (Apple apple : apples) {
            if(p.test(apple)){
                list.add(apple);
            }
        }
        return list;
    };
}

class Apple{
    private String color;
    private Double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

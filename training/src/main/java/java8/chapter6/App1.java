package java8.chapter6;

import java8.chapter5.Dish;
import java8.chapter5.Trader;
import java8.chapter5.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static java.util.stream.Collectors.*;
import  java.util.stream.Collectors;

/**
 * Author: wangyufei
 * CreateTime:2018/03/03
 * Companion:Champion Software
 */
public class App1 {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    private List<Dish> menu;
    private List<Transaction> transactions;

    @Before
    public void init() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("prawns2", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void method1() {
        Optional<Dish> maxCalories = menu.stream()
                .collect(Collectors.maxBy(new Comparator<Dish>() {
                    @Override
                    public int compare(Dish o1, Dish o2) {
                        return o1.getCalories() - o2.getCalories();
                    }
                }));
        System.out.println(maxCalories.get());
        Optional<Dish> maxCalories2 = menu.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(maxCalories2.get());
    }

    @Test
    public void method2() {
        Integer sumCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));//得到所有菜肴的卡路里总和
        System.out.println(sumCalories);

        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        //可以一次性计算出所有菜肴卡路里的count sum min average max
        System.out.println(intSummaryStatistics);
    }

    @Test
    public void method3() {
        String collectName = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(collectName);

        String collectName2 = menu.stream().map(Dish::getName).collect(Collectors.joining(" , "));
        System.out.println(collectName2);

    }

    @Test
    public void method4() {
        String joinName = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(joinName);
        String collectName = menu.stream().collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + "," + s2));
        System.out.println(collectName);
    }

    @Test
    public void method5() {
        //将menu根据Dish的type进行分组
        //Map<Dish.Type, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        //System.out.println(map);

        //根据自己定义的CaloricLevel来进行分组
        Map<CaloricLevel, List<Dish>> collectByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
            int calories = dish.getCalories();
            if (calories <= 400) {
                return CaloricLevel.DIET;
            } else if (calories <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));

        collectByCaloricLevel.keySet().stream().forEach(System.out::println);
        collectByCaloricLevel.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void method6() {
        //多级分组
        // Key是Dish.Type
        // Value是Map<CaloricLevel, List<Dish>>
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> mutilLevelGroup = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(
                dish -> {
                    int calories = dish.getCalories();
                    if (calories <= 300) {
                        return CaloricLevel.DIET;
                    } else if (calories <= 600) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        ));
        //System.out.println(mutilLevelGroup);


        //所以实际上下面这两种写法前一种是后一种的简写方式 可以直接省略toList
        Map<Dish.Type, List<Dish>> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Map<Dish.Type, List<Dish>> collect2 = menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.toList()));

        //根据DishType和Dish的个数来进行分组
        Map<Dish.Type, Long> map = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        //System.out.println(map);

        //找寻每个类别下 热量最高的菜
        Map<Dish.Type, Optional<Dish>> collect = menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
                );
        //System.out.println(collect);


        Map<Dish.Type, Dish> collect3 = menu.stream().collect(groupingBy(
                Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));//这个操作是安全的  因为reducing收集器永远都不会返回Optional.empty()
        System.out.println(collect3);
    }

    @Test
    public void method7() {
        //分区
        Map<Boolean, List<Dish>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(collect);
    }

}

package old.java8.chapter4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: wangyufei
 * CreateTime:2018/03/02
 * Companion:Champion Software
 */
public class App1 {

    private List<Dish> menu;

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
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    @Test
    public void method1() {
        List<String> list = menu.stream()//获取流
                .filter(d -> {
                    System.out.println("filtering...");
                    return d.getCalories() > 400;
                })//筛选卡路里大于400的食物
                .map(d -> {
                    System.out.println("mapping...");
                    return d.getName();
                })//只抽取菜名
                .limit(3)//抽取前三个
                .collect(Collectors.toList());
        //list.forEach(System.out::println);

    }
}

package java8.chapter4;

/**
 * Author: wangyufei
 * CreateTime:2018/03/02
 * Companion:Champion Software
 */
public class Dish {

    private final String name;//菜名
    private final boolean vegetarian;//素菜
    private final int calories;//卡路里
    private final Type type;//菜系
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }
}

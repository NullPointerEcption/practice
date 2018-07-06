package old.java8.chapter2;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class Apple {
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

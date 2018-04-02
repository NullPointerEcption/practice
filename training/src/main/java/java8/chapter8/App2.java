package java8.chapter8;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: wangyufei
 * CreateTime:2018/03/06
 * Companion:Champion Software
 */

public class App2 {
    public static void main(String[] args) {
        Point p1 = new Point(5,6);
        Point p2 = p1.moveRightBy(6);

        Assert.assertEquals(11,p2.getX());
    }
    @Test
    public void method() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());
    }

}

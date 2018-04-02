package java8.chapter7;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Author: wangyufei
 * CreateTime:2018/03/06
 * Companion:Champion Software
 */
public class App1 {

    @Test
    public void method() {
        //并行流测试
        int n=100;
        int result = 0;

        for (int i = 1; i <= 100; i++) {
            result+=i;
        }
        System.out.println(result);


        //串行流
        Integer reduceRes = Stream.iterate(1, n1 -> n1 + 1)
                .mapToInt(i->i)
                .limit(100)
                .reduce(0, Integer::sum);
        System.out.println(reduceRes);

        //并行流
        Long reduceRes1 = Stream.iterate(1L, n1 -> n1 + 1)
                .limit(100)
                .parallel()//将流转换成并行流
                .reduce(0L, Long::sum);
        System.out.println(reduceRes1);
    }

    @Test
    public void method1() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}

package java8.chapter5;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Author: wangyufei
 * CreateTime:2018/03/03
 * Companion:Champion Software
 */
public class App2 {

    @Test
    //由值创建流
    public void method() {
//        Stream.empty()//创建一个空的流
        Stream.of("白日依山尽", "黄河入海流")
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }

    @Test
    public void method2() {
        int[] ints = {1, 1, 2, 3, 4, 5};
        int sum = Arrays.stream(ints).sum();
        System.out.println(sum);
    }

    @Test
    public void method3() {

        try (Stream<String> lines = Files.lines(Paths.get("D:/a.txt"))) {
            lines.map(s -> s.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void method4() {
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t ->
                new int[]{t[1], t[0] + t[1]}
        ).limit(20).forEach(t->System.out.println(t[0]+","+t[1]));
    }

}

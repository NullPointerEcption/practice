import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Terminal,一个Stream只能执行一次terminal 操作，而且只能是最后一个操作，执行terminal操作之后，Stream就被消费掉了，并且产生一个结果。
 常用操作：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny
 * Created by Administrator on 2018/02/14.
 */
public class StreamLearning3 {
    public static void main(String[] args) {

        String[] strArr = new String[]{"aa","bb","cc"};
        Stream<String> streamArr = Stream.of(strArr);
        int[] intArr = new int[]{1,2,3,4,5,6};
        Stream<int[]> integerStream = Stream.of(intArr);      //???

        //forEach
        streamArr.forEach(System.out::println);

        //forEachOrdered 如果希望顺序执行并行流，请使用该方法
        streamArr.parallel().forEachOrdered(System.out::println);

        //toArray 收集到数组中
        streamArr.filter(str -> str.startsWith("a")).toArray(String[]::new);

        //reduce 聚合操作
        streamArr.reduce((str1, str2) -> str1 + str2);

        //collect 收集到List中
        streamArr.collect(Collectors.toList());

        //collect 收集到Set中
        streamArr.collect(Collectors.toSet());

        //min 取最小值？
        IntStream.of(1,2,3,4).min();

        Stream.of(strArr).min(String::compareTo);
        //max 取最大值？
        IntStream.of(1,2,3,4).max();
        //        Stream.of(arr).max(String::compareTo);
        //count 计算总量？
        streamArr.count();
        //anyMatch 判断流中是否含有匹配元素
        boolean hasMatch = streamArr.anyMatch(str -> str.startsWith("a"));
        //allMatch 判断流中是否全部匹配
        //        boolean hasMatch = streamArr.allMatch(str -> str.startsWith("a"));
        //noneMatch 判断流中是否全部不匹配
        //        boolean hasMatch = streamArr.noneMatch(str -> str.startsWith("a"));
        //findFirst 找到第一个就返回
        streamArr.filter(str -> str.startsWith("a")).findFirst();
        //findAny 找到任意一个就返回
        streamArr.filter(str -> str.startsWith("a")).findAny();

    }
}

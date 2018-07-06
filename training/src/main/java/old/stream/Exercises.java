package old.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/02/14.
 *
 * 数组去重
 */
public class Exercises {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("I am a boy");
        list.add("I love the girl");
        list.add("But the girl loves another girl");

        List<String> collect = list.stream()
                .map(line -> line.split(" "))
//                .map(Arrays::stream)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
       //collect.forEach(System.out::println);




        int[] intArr1 = new int[]{1,2,3,4,5,6};
        int[] intArr2 = new int[]{11,22,33,44,55,66};
        IntStream intStream = Stream.of(intArr1, intArr2)
                .flatMapToInt(Arrays::stream);

        List<Integer> intList = intStream.boxed().collect(Collectors.toList());//因为int是基本数据类型 所以包装出来的stream需要box装箱才能被collect
        intList.forEach(i->{
            System.out.println("intList:"+i);
        });

        //long count = intStream.count();
        //System.out.println(count);

    }
}

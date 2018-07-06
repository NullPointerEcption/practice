package old.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/02/13.
 *
 *
 * 获得stream对象的几种方式
 */
public class StreamLearning {

    public static void main(String[] args) {

        //数组
        String[] strArr = new String[]{"aa","bb","cc"};
        Stream<String> streamArr = Stream.of(strArr);
        Stream<String> streamArr2 = Arrays.stream(strArr);
        //集合
        List<String> list = new ArrayList<>();
        Stream<String> streamList = list.stream();
        Stream<String> streamList2 = list.parallelStream();//并行执行
        streamArr2.forEach(i->{
            System.out.println(i);
        });

        //generator 生成无限长度的stream
        Stream.generate(Math::random);
        // iterate 也是生成无限长度的Stream，其元素的生成是重复对给定的种子值调用函数来生成的
        Stream.iterate(1, item -> item + 1);
    }

}

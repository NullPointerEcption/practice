package old.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/02/14.
 *
 *  Intermediate,一个Stream可以调用0到多个Intermediate类型操作，每次调用会对Stream做一定的处理，
 返回一个新的Stream，这类操作都是惰性化的（lazy），就是说，并没有真正开始流的遍历。
 常用操作：map (mapToInt,mapToDouble,mapToLong, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel
 */
public class StreamLearning2 {

    private static ArrayList<String> strList;
    static{
        strList=new ArrayList<>();
        strList.add("aaa");
        strList.add("aaa1");
        strList.add("aaa2");
        strList.add("aaa3");
        strList.add("aaa4");
        strList.add("bbb");
        strList.add("bbb1");
        strList.add("bbb2");
        strList.add("bbb3");
        strList.add("bbb4");
        strList.add("ccc");
        strList.add("ccc1");
        strList.add("ccc2");
        strList.add("ccc3");
        strList.add("ccc4");
        strList.add("ccc5");
        strList.add("ccc6");
    }

    public static void main(String[] args) {

//        strList.stream()
//                .filter(s->s.startsWith("a"))//过滤
//                .map(s->s.toUpperCase())//遍历和转换操作
//                .limit(3)//提取前多少个
//                .skip(1)//跳过前多少个
//                .distinct()//去重
//                .sorted(Comparator.comparing(String::length).reversed())//排序
//                .peek(s-> System.out.println("peek:"+s))//产生相同的流 支持每个元素调用一个函数
//                .forEach(s-> System.out.println("forEach:"+s));

        //map
        strList.stream().map(str->str.toUpperCase()+"哈哈").forEach(str-> System.out.println(str));

        //flatMap 将流展开
        List<String> list1 = new ArrayList<>();
        list1.add("aa");list1.add("bb");
        List<String> list2 = new ArrayList<>();
        list2.add("cc");list2.add("dd");
        Stream.of(list1,list2)
                .flatMap(str -> str.stream())
                .collect(Collectors.toList())
                .forEach(s-> System.out.println(s));

    }
}

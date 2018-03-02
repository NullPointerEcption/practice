package java8.chapter3;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

/**
 * Author: wangyufei
 * CreateTime:2018/03/02
 * Companion:Champion Software
 *
 * 特别版本的Function Interface
 * 为了避免装箱、拆箱的操作，专门提供给int、byte、short、char、long等基本数据类型的函数式接口
 *
 */
public class App1 {

    @org.junit.Test
    public void method1() {
        IntPredicate numValidae=i->i>80;//因为用了IntPredicate 所以这里的i就是原始数据类型的
        System.out.println(numValidae.test(90));
    }

    @org.junit.Test
    public  void method2(){
        //这种写法就会造成装箱
        Predicate<Integer> numVal = (Integer i)->i%2==0;
        List<Integer> integers = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numsFiltered = integers.stream().filter(numVal).collect(toList());
        numsFiltered.forEach(System.out::println);
    }
    @org.junit.Test
    public  void  method3(){
        //TUR  T U->R
        BiFunction<String,Integer,Integer> biFunction=new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return s.length()*integer;
            }
        };
    }
    @org.junit.Test
    public void method4(){
        List<String> list = Arrays.asList("a", "bcde", "A", "B", "ABC", "abc");
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }





}

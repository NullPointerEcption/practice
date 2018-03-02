package java8.chapter2.lambdaDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 * 函数式接口的案例 读取一行或者多行文件里面的内容 直接在lambda中实现
 */
public class App {
    public static void main(String[] args) throws  Exception{

//        String lines = processFile((reader) -> reader.readLine()+reader.readLine());
//        String oneLine = processFile((reader) -> reader.readLine());
//        System.out.println(lines);
//        System.out.println(oneLine);


        //Consumer:使用lambda表达式直接创建一个Consumer实例对象
        forEach(Arrays.asList(2,3,4,5,4,3,2,1),i-> System.out.print(i+"\t"));

        //Function:使用function 将List<String> 里的每个字符串 输出为 List<Integer> 每个字符串的长度
       // List<Integer> strLength = map(Arrays.asList("aaa", "bbbb", "cccc"), s -> s.length());
        //strLength.forEach(i-> System.out.println(i));

        List<String> result = map(Arrays.asList(3, 4, 5, 6, 7, 80), i -> i + "hello");
        List<String> result2 = map(Arrays.asList(3, 4, 5, 6, 7, 80), new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer+"heheda";
            }
        });
        result2.forEach(System.out::println);

    }

    public  static  String processFile(BufferedReaderProcessor processor) throws IOException {

        try (
                BufferedReader br=new BufferedReader(new FileReader("D:\\a.txt"));
        ){
            return  processor.process(br);
        }
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t : list){
            c.accept(t);
        }
    }

    /**
     * 将List<T>类型的数据转换成List<R>类型的数据
     * @param list 源数据
     * @param f 转换方法
     * @param <T> 源类型
     * @param <R> 目标类型
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){

        List<R> result = new ArrayList<>();

        for (T s : list){
            result.add(f.apply(s));
        }

        return  result;
    }

}
@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}

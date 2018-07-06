package old.java8.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author: wangyufei
 * CreateTime:2018/03/02
 * Companion:Champion Software
 */
public class App1 {

    private List<Dish> menu;
    private List<Transaction> transactions;

    @Before
    public void init() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void method1() {
        List<String> list = menu.stream()//获取流
                .map(d -> d.getName())
                .collect(Collectors.toList());
    }

    @Test
    /**
     * map演示
     */
    public void method2() {
        //打印每个单词的长度
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
//        words.stream()
//                .map(String::length)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        words.stream()
                .map(s -> {
                    return "world:" + s + "\tlength:" + s.length();
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }


    /**
     * flatMap
     */
    @Test
    public void method3() {
//        ["Hello","World"] 返回 ["H","e","l", "o","W","r","d"] 字符各不相同
        List<String> words = Arrays.asList("Hello", "World");
        //这样做话就是把一个单词
        words.stream()//获取流
                .map(i -> i.split(""))//把里面的每一个单词变成了一个数组
                .distinct()//去重
                .collect(Collectors.toList())//把这两个获得的数组合成了一个list
                .forEach(System.out::println);//打印
    }

    @Test
    public void method4() {

//        String[] strArr = {"aaa","bbb","ccc"};
//        Stream<String> stream = Arrays.stream(strArr);

        List<String> words = Arrays.asList("Hello", "World");
        words.stream().map(w -> w.split(""))//把里面的每一个单词变成了一个数组
                .map(Arrays::stream)//把每一个数组 变成对应的流
                .collect(Collectors.toList())//collect一下
                .forEach(System.out::println);//这里打印的是流

        //使用flatMap进行扁平化的流抽取
        words.stream().map(w -> w.split(""))//把里面的每一个单词变成了一个数组
                .flatMap(Arrays::stream)//flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
                .collect(Collectors.toList())//collect一下
                .forEach(System.out::println);//这里打印的是流


    }

    @Test
    public void method5() {
        //        [1, 2, 3, 4, 5]，应该返回[1, 4, 9, 16, 25]。
        //Arrays.asList(1,2,3,4,5).stream().map(i->i*i).forEach(System.out::println);

        //例如，给定列表[1, 2, 3]和列表[3, 4]，应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);

        nums1.stream()
                .flatMap(i1 -> nums2
                        .stream()
                        .filter(i2 -> (i1 + i2) > 6)
                        .map(i2 -> new int[]{i1, i2}))
                .collect(Collectors.toList())
                .forEach(arr -> System.out.println("(" + arr[0] + "," + arr[1] + ")"));
    }

    @Test
    public void method6() {
        Optional<Dish> dishOptional = menu.stream().filter(m -> m.getType().equals(Dish.Type.OTHER)).findAny();
        Dish dish = dishOptional.get();
        System.out.println(dish);
    }

    @Test
    public void method7() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Map.Entry<String, Integer>> listFromMap = new ArrayList<>(entries);
        listFromMap.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        listFromMap.forEach(m -> System.out.println(m.getKey() + ":" + m.getValue()));

    }

    @Test
    public void method8() {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("d", 4);
        map.put("c", 3);
        map.put("b", 2);
        map.put("f", 5);
        map.put("e", 6);

        Arrays.asList(map)
                .stream()
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    public void method9() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

//        int result = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
        int result = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println(result);
        int multiplyResult = Arrays.stream(arr).reduce(1, (a, b) -> a + b);
        System.out.println(multiplyResult);

        Optional<Integer> reduce = Arrays.stream(arr).boxed().reduce((a, b) -> a + b + 1);
        reduce.ifPresent(System.out::println);
    }

    @Test
    public void method10() {

        Optional<Integer> reduce = menu.stream()
                .map(dish -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
        long count = menu.stream().count();
        System.out.println(count);

    }

    @Test
    public void method11() {
        System.out.println("(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
//                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("(2) 交易员都在哪些不同的城市工作过？");
        transactions.stream()
                .map(t -> t.getTrader())
                .map(t -> t.getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("(3) 查找所有来自于剑桥的交易员，并按姓名排序。");
        transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
//                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);


        System.out.println("(4) 返回所有交易员的姓名字符串，按字母顺序排序。");
        Optional<String> totalName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted((t1, t2) -> t1.compareTo(t2))
//                .reduce((n1,n2)->n1+n2)
                .reduce(String::concat);

        String totalName2 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted((t1, t2) -> t1.compareTo(t2))
                .collect(Collectors.joining());
        System.out.println(totalName);
        System.out.println(totalName2);

        System.out.println("(5) 有没有交易员是在米兰工作的？");
        Optional<String> ifTraderInMilan = transactions.stream()
                .map(t -> t.getTrader())
                .map(t -> t.getCity())
                .filter(c -> c.equals("Milan"))
                .findAny();
        System.out.println(ifTraderInMilan.get());

        boolean isInmilan = transactions.stream()
                .map(t -> t.getTrader())
                .map(t -> t.getCity())
                .anyMatch(c -> c.equals("Milan"));
        //直接简写成这个更方便
        transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println(isInmilan);

        System.out.println("(6) 打印生活在剑桥的交易员的所有交易额。");
        Optional<Integer> sumOfcambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .reduce(Integer::sum);
        System.out.println(sumOfcambridge);

        System.out.println("(7) 所有交易中，最高的交易额是多少？");
        Optional<Integer> max = transactions.stream()
                .map(t -> t.getValue())
                .max(Integer::compare);
        Optional<Transaction> max1 = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        System.out.println(max);
        System.out.println(max1);

        System.out.println("(8) 找到交易额最小的交易");
        Optional<Integer> min = transactions.stream()
                .map(t -> t.getValue())
                .min(Integer::compare);

        Optional<Transaction> min1 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(min);
        System.out.println(min1);
    }

    @Test
    public void method12() {

        int caloriesSum = menu.stream()
                .mapToInt(Dish::getCalories)//得到IntStream
//                .max()
//                .min()
//                .average()
                .sum();//得到卡路里的总和
        System.out.println(caloriesSum);

        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();//OptionalInt可以理解成返回的是int数据类型的Optional
        System.out.println(maxCalories.orElse(0));//返回最大值或者没有最大值返回0


        Stream<Integer> boxedInteger = menu.stream()
                .mapToInt(m -> m.getCalories())//得到的是IntStream
                .boxed();//得到的是Stream<Integer>
    }

    @Test
    public void method13() {
        //都是直接产生的原始类型的数字，没有装箱拆箱操作
        //rangeClosed包含结束值 range不包含结束值
        IntStream.rangeClosed(1,100).filter(i->i%3==0).forEach(System.out::println);


    }

}

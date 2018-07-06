package old.interview.javabase;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App13 {
    @Test
    public void test() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            integers.remove(1);
        }
    }

    @Test
    public void test1() throws Exception {
        Class.forName("old.interview.javabase.MyStaticClass");
    }
}
class MyStaticClass{
    static {
        System.out.println("MyStaticClass");
    }
}
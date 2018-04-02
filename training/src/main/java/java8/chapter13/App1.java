package java8.chapter13;

import org.junit.Test;

public class App1 {

    int n = 10000;

    @Test
    public void test() throws Exception {
        long start = System.nanoTime();
        long res = factorialRecursive(n);
        //14666
        System.out.println(String.format("res:%d , 共计耗时 : %d 纳秒",res,System.nanoTime()-start));

//        long start2 = System.nanoTime();
//        long res2 = factorialTailRecursive(n);
//        //14667
//        System.out.println(String.format("res:%d , 共计耗时 : %d 纳秒",res2,System.nanoTime()-start2));
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n-1);
    }

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }

    @Test
    public void test3() throws Exception {
        double d1 = 3.14;
        double d2 = d1;
        Double o1 = d1;
        Double o2 = d2;
        Double ox = o1;
        System.out.println(d1 == d2 ? "yes" : "no");
        System.out.println(o1 == o2 ? "yes" : "no");
        System.out.println(o1 == ox ? "yes" : "no");
    }
}

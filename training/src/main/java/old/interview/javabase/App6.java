package old.interview.javabase;

import org.junit.Assert;
import org.junit.Test;

public class App6 {
    /**
     * 一个数组：1,1,2,3,5,8,13,21...+m，求第30位数是多少？分别用递归和非递归实现；(常考！！！)
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Assert.assertEquals(fibonachi1(30),fibonachi2(30)[29]);
    }

    public int fibonachi1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonachi1(n - 1) + fibonachi1(n - 2);
    }

    public int[] fibonachi2(int n) {
        int[] res = new int[n];
        if (n <= 0) {
            throw new IllegalArgumentException("parameter n:" + n + " is not a legal parameter !");
        }
        if (n <= 2) {
            res[0] = 1;
            if (n == 2) {
                res[1] = 1;
            }
            return res;
        }

        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res;
    }

    /**
     * Integer的创建和缓冲池
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Integer a = new Integer(3);
        Integer b = 3;
        Integer c = 3;
        int d = 3;
        int e = 3;

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c==d);
        System.out.println(d==e);

    }

    public static void main(String[] args) {
        try {
            System.exit(0);
            return;
        }finally {
            System.out.println("fianlly...");
        }
    }


}

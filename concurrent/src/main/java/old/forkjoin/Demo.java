package old.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author wangyufei
 * @date 2018/10/21
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(forkJoinCalc());
        //System.out.println(singleThreadCalc(45));
        System.out.println((System.currentTimeMillis() - start));

    }

    private static int singleThreadCalc(int n) {
        if (n <= 2) {
            return n;
        }
        return singleThreadCalc(n - 1) + singleThreadCalc(n - 2);
    }

    private static int forkJoinCalc() throws InterruptedException, ExecutionException {
        Fibonacci fibonacci = new Fibonacci(45);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = forkJoinPool.submit(fibonacci);
        return result.get();
    }

}

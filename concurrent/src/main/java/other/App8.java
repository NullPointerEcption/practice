package other;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试Callable
 */
public class App8 {
    public static void main(String[] args) {
        List<Future<Double>> futures=new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            Future<Double> submit = executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Thread.sleep(100);
                    return Math.random();
                }
            });
            futures.add(submit);
        }

        try {
            System.out.println("主线程睡了一秒");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        futures.forEach((item)->{
            try {
                System.out.println(item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}

package old.java8.chapter11;

import org.junit.Test;

import java.util.concurrent.*;

public class App1 {
    /**
     * java8之前的future使用模式
     *
     * @throws Exception
     */
    @Test
    public void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                //经过一系列复杂的操作
                return 2d;
            }
        });

        //做一些其他的事情

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //线程等待过程中被中断的
            e.printStackTrace();
        } catch (ExecutionException e) {
            //计算过程中被中断的
            e.printStackTrace();
        } catch (TimeoutException e) {
            //超时
            e.printStackTrace();
        }

    }
}

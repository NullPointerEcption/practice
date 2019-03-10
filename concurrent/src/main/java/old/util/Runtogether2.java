package old.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 并发执行工具
 * @author: WangYuFei
 * @create: 2019-01-07 17:03
 **/
public class Runtogether2 {

    /**
     * 同时运行某段代码
     *
     * @param dosomething sth
     */
    public static void runTogether(int count, Dosomething dosomething, CountDownLatch countDownLatch) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " ready!");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    dosomething.call();
                    System.out.println("Thread: " + Thread.currentThread().getName() + " finish!");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
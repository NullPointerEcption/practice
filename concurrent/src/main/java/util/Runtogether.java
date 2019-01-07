package util;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 并发执行工具
 * @author: WangYuFei
 * @create: 2019-01-07 17:03
 **/
public class Runtogether {

    private static int count = 100;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    /**
     * 同时运行某段代码
     *
     * @param dosomething sth
     */
    public static void runTogether(Dosomething dosomething) {
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " ready!");
                try {
                    dosomething.call();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
    }

    /**
     * 暂停
     */
    public static void await(){
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
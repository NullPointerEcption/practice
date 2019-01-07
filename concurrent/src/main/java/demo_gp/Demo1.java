package demo_gp;

import java.util.concurrent.TimeUnit;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-04 14:03
 **/
public class Demo1 {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "___" + i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
        Thread.interrupted();
    }
}

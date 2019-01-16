package demos;

import util.Runtogether2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-07 17:13
 **/
public class DemoTest {

    private static int count = 1_000;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        Runtogether2.runTogether(count, () -> {
            TimeUnit.MILLISECONDS.sleep(10);
            count -= 1;
        }, countDownLatch);

        countDownLatch.await();
        System.out.println(count);
    }
}

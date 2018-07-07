package commoncls;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的使用 await之后等待countDown的次数==new CountDownLatch(count)的count
 */
public class CountDownLacthDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                    countDownLatch.await();
                    System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                countDownLatch.countDown();
                System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                countDownLatch.countDown();
                System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
            }
        }).start();

    }
}

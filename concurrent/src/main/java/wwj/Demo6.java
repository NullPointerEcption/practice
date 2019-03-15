package wwj;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-09 15:32
 **/
public class Demo6 {
    public static void main(String[] args) {
        //new WindowThread().start();
        //new WindowThread().start();
        //new WindowThread().start();

        //WindowRunnable windowRunnable = new WindowRunnable();
        //new Thread(windowRunnable).start();
        //new Thread(windowRunnable).start();
        //new Thread(windowRunnable).start();

        Runnable runnable = () -> {
            AtomicInteger index = new AtomicInteger(1);
            while (index.get() <= 50) {
                System.out.println(Thread.currentThread().getName() + "_____" + index.get());
                index.incrementAndGet();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

class WindowThread extends Thread {
    private static int index = 1;

    @Override
    public void run() {
        while (index <= 50) {
            System.out.println(Thread.currentThread().getName() + "_______" + index);
            index++;
        }
    }
}

class WindowRunnable implements Runnable {
    private static int index = 1;

    @Override
    public void run() {
        while (index <= 50) {
            System.out.println(Thread.currentThread().getName() + "_______" + index);
            synchronized ("") {
                index++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
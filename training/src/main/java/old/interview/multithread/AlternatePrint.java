package old.interview.multithread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangyufei
 * @version 2018/10/15 16:02
 * @description 交替打印 线程一打印1 线程二打印2 线程一打印3 线程二打印4 ...
 */
public class AlternatePrint {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger num = new AtomicInteger(0);
        AtomicBoolean isThreadANow = new AtomicBoolean(true);

        new Thread("线程A") {
            @Override
            public void run() {
                synchronized (lock) {
                    while (num.intValue() < 100) {
                        try {
                            if(isThreadANow.get()){
                                System.out.println(Thread.currentThread().getName() + "打印：" + num.incrementAndGet());
                                //Thread.sleep(1000);
                                isThreadANow.set(false);
                                lock.notify();
                                lock.wait();
                            }
                        } catch (Exception e) {
                        }
                    }
                    System.out.println("线程A执行完毕");
                    lock.notify();
                }
            }
        }.start();


        new Thread("线程B") {
            @Override
            public void run() {
                synchronized (lock) {
                    while (num.intValue() < 100) {
                        try {
                            if(!isThreadANow.get()){
                                System.out.println(Thread.currentThread().getName() + "打印：" + num.incrementAndGet());
                                //Thread.sleep(1000);
                                isThreadANow.set(true);
                                lock.notify();
                                lock.wait();
                            }
                        } catch (Exception e) {
                        }
                    }
                    System.out.println("线程B执行完毕");
                }
            }
        }.start();
    }
}



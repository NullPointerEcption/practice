package old.demos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-02 17:54
 **/
public class Demo2Test {
    public static void main(String[] args) throws InterruptedException {
        Ticket target = new Ticket();
        Thread thread = new Thread(target);
        thread.start();
        Thread thread1 = new Thread(target);
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(Ticket.ticket);
    }
}

class Ticket implements Runnable {
    //共100票
    static int ticket = 100;

    //创建Lock锁对象
    Lock ck = new ReentrantLock();

    @Override
    public void run() {
        //模拟卖票
        while (true) {
            //synchronized (old.lock){
            ck.lock();
            try {
                if (ticket > 0) {
                    //模拟选坐的操作
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket--);
                } else {
                    break;
                }
            } finally {
                ck.unlock();
            }
            //}
        }
    }
}
package demos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-02 17:54
 **/
public class Demo2Test {
    public static void main(String[] args) {
        Ticket target = new Ticket();
        new Thread(target).start();
        new Thread(target).start();
    }
}

class Ticket implements Runnable {
    //共100票
    int ticket = 100;

    //创建Lock锁对象
    Lock ck = new ReentrantLock();

    @Override
    public void run() {
        //模拟卖票
        while (true) {
            //synchronized (lock){
            ck.lock();
            if (ticket > 0) {
                //模拟选坐的操作
                //try {
                //    Thread.sleep(10);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket--);
            } else {
                break;
            }
            ck.unlock();
            //}
        }
    }
}
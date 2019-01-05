package demos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-02 16:33
 **/
public class Demo1Test {

    public static void main(String[] args) {
        new BankThread("Thread_Husband").start();
        new BankThread("Thread_Wife").start();
    }

}

class BankThread extends Thread {

    private String name;

    public BankThread(String name) {
        super(name);
    }

    static int count = 5000;

    Lock ck = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            synchronized ("锁") {
                //"锁".notify();
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + ",取走一千，剩余" + (count - 1000));
                    count -= 1000;
                    //try {
                    //    "锁".wait();
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                } else {
                    System.out.println("take over...");
                    break;
                }
            }

        }
    }
}
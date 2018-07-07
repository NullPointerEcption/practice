package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的使用
 */
public class ReentrantLockDemo implements Runnable {


    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入了method1...");
            Thread.sleep(1000);

            System.out.println("释放锁");
            condition.await();//释放锁

            System.out.println(Thread.currentThread().getName() + "退出了method1...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入了method2...");
            Thread.sleep(1500);

            System.out.println("唤醒锁");
            condition.signal();//唤醒锁

            System.out.println(Thread.currentThread().getName() + "退出了method2...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 单纯在一个线程内执行这个方法会永远的卡住
     */
    @Override
    public void run() {
        method1();
        method2();
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(()->{demo.method1();},"t1").start();
        new Thread(()->{demo.method2();},"t2").start();
    }
}

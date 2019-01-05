package demos;

/**
 * @description: 一个银行账户5000块，两夫妻一个拿着 存折，一个拿着卡，开始取钱比赛，每次只能取一千块，要求不准出现线程安全问题。（易忽视点：因为是共享的，需要将操作的对象5000元用static修饰）
 * @author: WangYuFei
 * @create: 2019-01-02 16:18
 **/
public class Demo1 {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        new Thread(() -> bankAccount.takeMoney(), "Thread_Husband").start();
        new Thread(() -> bankAccount.takeMoney(), "Thread_Wife").start();
        //new Thread(() -> bankAccount.takeMoney(), "Thread_Son").start();
    }
}
class BankAccount {
    private int money = 5000;
    private final Object lock = new Object();
    public void takeMoney() {
        synchronized (lock) {
            while (true) {
                lock.notifyAll();
                if (money > 0) {
                    money = money - 1;
                    System.out.println(Thread.currentThread().getName() + " 取出一千块，余额为：" + money);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "尝试取钱，但已经取完了！");
                    break;
                }
            }
        }

    }
}
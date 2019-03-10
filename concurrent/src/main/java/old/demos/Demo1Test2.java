package old.demos;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-02 16:33
 **/
public class Demo1Test2 {

    public static void main(String[] args) {
        new BankThread2("Thread_Husband").start();
        new BankThread2("Thread_Wife").start();
    }

}

class BankThread2 extends Thread {

    private String name;

    public BankThread2(String name) {
        super(name);
    }

    static int count = 5000;

    @Override
    public void run() {
        while (true) {
            synchronized ("锁") {
                "锁".notify();
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + ",取走一千，剩余" + (count - 1000));
                    count -= 1000;
                    try {
                        "锁".wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("take over...");
                    break;
                }
            }

        }
    }
}
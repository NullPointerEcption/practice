package demos;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-03 11:15
 **/
public class Demo3 {

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(() -> testLock.sayHi(), "Thread_A").start();
        new Thread(() -> testLock.sayHi(), "Thread_B").start();

        TestLock testLock2 = new TestLock();
        new Thread(() -> testLock2.sayHi(), "Thread_C").start();
        new Thread(() -> testLock2.sayHi(), "Thread_D").start();
    }

}

class TestLock {

    private int number = 0;

    private final Object lock = new Object();
    private static final Object lock2 = new Object();
    Class<TestLock> lock3 = TestLock.class;

    public void sayHi() {
        while (true) {
            synchronized (lock) {
                number++;
                System.out.println(Thread.currentThread().getName() + "_hello . " + number);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

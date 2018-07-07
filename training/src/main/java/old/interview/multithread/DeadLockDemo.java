package old.interview.multithread;

public class DeadLockDemo {

    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        new DeadThread1().start();
        new DeadThread2().start();
    }
}

class DeadThread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (DeadLockDemo.LOCK_1) {
                try {
                    System.out.println("进入了DeadThread1");
                    Thread.sleep(1000);
                    synchronized (DeadLockDemo.LOCK_2) {
                        System.out.println("进入了DeadThread1的内部");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class DeadThread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (DeadLockDemo.LOCK_2) {
                try {
                    System.out.println("进入了DeadThread2");
                    Thread.sleep(1000);
                    synchronized (DeadLockDemo.LOCK_1) {
                        System.out.println("进入了DeadThread2的内部");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package old.multithread.javazhiyin;

/**
 * @author wangyufei
 * @version 2018/10/09 8:29
 * @description 细粒度控制线程交替打印测试 A打印1 B打印123 A再打印23
 */
public class Demo2 {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        long l = System.currentTimeMillis();

        Thread threadA = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程A打印1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程A打印2");
                    System.out.println("线程A打印3");
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程B打印1");
                    System.out.println("线程B打印2");
                    System.out.println("线程B打印3");
                    lock.notify();
                }
            }
        };

        threadA.start();
        threadB.start();
    }

}

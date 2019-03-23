package wwj;

/**
 * <p>
 * Description: 执行静态方法必须等静态代码块先执行完
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-20 17:57
 **/
public class Demo22 {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                StaticLockDemo.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();
        //new Thread(() -> {
        //    try {
        //        StaticLockDemo.m2();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();

        //
        new Thread(StaticLockDemo::m3, "T3").start();
    }

}

class StaticLockDemo {

    static {
        synchronized (StaticLockDemo.class) {
            System.out.println("初始化静态代码块" + Thread.currentThread().getName());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized static void m1() throws InterruptedException {
        System.out.println("同步静态方法1111");
        Thread.sleep(3 * 1000);
    }

    public synchronized static void m2() throws InterruptedException {
        System.out.println("同步静态方法2222");
        Thread.sleep(3 * 1000);
    }

    public static void m3() {
        System.out.println("非同步静态方法3333");
    }

}
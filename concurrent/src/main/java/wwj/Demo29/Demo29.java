package wwj.Demo29;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * <p>
 * Description: 自定义显示锁
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-22 16:46
 **/
public class Demo29 {
    private MyLock myLock = new MyBooleanLock();

    public void test1() throws Exception {
        myLock.lock();
        System.out.println(" i am method 1");
        TimeUnit.SECONDS.sleep(5);
        myLock.unlock();
    }

    public void test2() throws Exception {
        myLock.lock();
        System.out.println(" i am method 2");
        TimeUnit.SECONDS.sleep(5);
        myLock.unlock();
    }

    public static void main(String[] args) throws Exception {
        //Demo29 demo29 = new Demo29();
        //demo29.test1();
        //demo29.test2();

        final MyLock myLock = new MyBooleanLock();
        Stream.of("T1", "T2", "T3", "T4").forEach(name -> new Thread(() -> {
            try {
                myLock.lock();
                System.out.println(" i am method --- " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
            } finally {
                myLock.unlock();
            }
        }).start());
        TimeUnit.SECONDS.sleep(1);
        myLock.unlock();

    }

}

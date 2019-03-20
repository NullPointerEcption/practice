package myproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-19 18:23
 **/
public class MainTest {

    public static void main2(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(200);
        ThreadLocal<Log> threadLocal = MyLocal.threadLocal;
        for (int i = 0; i < 1000; i++) {
            final int i2 = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Log log = threadLocal.get();
                    log.setI2(i2);
                    log.setDetail(i2 % 2 == 0 ? "even" : "odd");
                    System.out.println(threadLocal.get());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        threadLocal.get().setDetail("i am main...");
        System.out.println("i am main : " + threadLocal.get());
    }

    public static void main3(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(200);

        for (int i = 0; i < 2000; i++) {
            final int i2 = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                }

                OperationContext context = OperationContext.getContext();
                context.setI2(i2);
                context.setDetail(i2 % 2 == 0 ? "even" : "odd");
                System.out.println(context.getLog());
                semaphore.release();
            });
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
        //new Thread(() -> {
        //    Log log = MyLocal.threadLocal.get();
        //    log.setDetail("i am in run-1.");
        //    System.out.println(log);
        //}, "run-1").start();
        //
        //new Thread(() -> {
        //    Log log = MyLocal.threadLocal.get();
        //    log.setDetail("i am in run-2.");
        //    System.out.println(log);
        //}, "run-2").start();

        System.out.println(MyLocal.threadLocal.get());

        Log log = new Log();
        log.setI2(100);
        log.setDetail("main changed");
        log.setTime(System.nanoTime());
        MyLocal.threadLocal.set(log);
        System.out.println(MyLocal.threadLocal.get());

        MyLocal.threadLocal.remove();
        System.out.println(MyLocal.threadLocal.get());
    }

}

class MyLocal {
    public static final ThreadLocal<Log> threadLocal = ThreadLocal.withInitial(() -> {
        Log log = new Log();
        log.setI2(0);
        log.setTime(System.nanoTime());
        return log;
    });
}
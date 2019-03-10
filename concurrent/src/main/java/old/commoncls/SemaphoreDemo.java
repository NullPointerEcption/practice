package old.commoncls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore的使用 acquire获得许可 release释放许可 可以做到限流
 */
public class SemaphoreDemo {


    public static void main(String[] args) throws Exception{
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //只能五个线程同时访问
        final Semaphore semp=new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();//获得许可
                        System.out.println("NO:"+index);
                        Thread.sleep((long)(Math.random()*5000));//随机休眠
                        semp.release();//释放许可
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            cachedThreadPool.execute(runnable);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(semp.getQueueLength());

//
//
//        // 退出线程池
        cachedThreadPool.shutdown();
    }
}

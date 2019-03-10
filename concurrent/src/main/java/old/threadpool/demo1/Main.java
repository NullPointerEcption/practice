package old.threadpool.demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Data> queue=new LinkedBlockingQueue<Data>();
        Provider provider1=new Provider(queue);
        Provider provider2=new Provider(queue);
        Provider provider3=new Provider(queue);

        Consumer consumer1=new Consumer(queue);
        Consumer consumer2=new Consumer(queue);
        Consumer consumer3=new Consumer(queue);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(provider1);
        cachedThreadPool.execute(provider2);
        cachedThreadPool.execute(provider3);
        cachedThreadPool.execute(consumer1);
        cachedThreadPool.execute(consumer2);
        cachedThreadPool.execute(consumer3);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        provider1.stop();
        provider2.stop();
        provider3.stop();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        cachedThreadPool.shutdown();
//        cachedThreadPool.shutdownNow();

    }
}

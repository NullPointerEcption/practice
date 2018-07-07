package threadpool.demo1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {

    //共享内存空间
    private BlockingQueue<Data> queue;
    //多线程间是否启动变量 有强制从主内存中刷新的功能 及时返回线程的状态
    private volatile boolean isRunning = true;
    //全局 id
    private static AtomicInteger count = new AtomicInteger();
    //随机对象
    private static Random r = new Random();

    public Provider(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(r.nextInt(1000));
                int id = count.incrementAndGet();
                Data data = new Data(id, "数据" + id);
                System.out.println("当前线程：" + Thread.currentThread().getName() + "获取到数据:" + data.toString() + "，加载到公共缓冲区...");
                if (!this.queue.offer(data,2, TimeUnit.SECONDS)) {
                    System.out.println("数据" + data + "加入缓冲区失败");
                    //do something...
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}

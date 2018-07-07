package threadpool.demo1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    //共享内存空间
    private BlockingQueue<Data> queue;

    private static Random r=new Random();

    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Data data = this.queue.take();
                Thread.sleep(r.nextInt(1000));
                System.out.println("当前消费线程:" + Thread.currentThread().getName() + ",消费成功，消费数据" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

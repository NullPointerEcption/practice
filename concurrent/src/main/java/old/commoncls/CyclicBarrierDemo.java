package old.commoncls;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier的使用 看调用了几次await
 */
public class CyclicBarrierDemo {

    static class Runner implements Runnable {
        private CyclicBarrier barrier;
        private String name;

        public Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*(new Random()).nextInt(5));
                System.out.println("运动员" + name + ",已经准备好了...");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("运动员" + name + ",GO...");
        }
    }


    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(3);

        Runner zhangsan = new Runner(barrier, "zhangsan");
        Runner lisi = new Runner(barrier, "lisi");
        Runner wangwu = new Runner(barrier, "wangwu");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(zhangsan);
        executorService.submit(lisi);
        executorService.submit(wangwu);

        executorService.shutdown();
    }
}

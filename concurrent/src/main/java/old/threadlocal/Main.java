package old.threadlocal;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wangyufei
 * @date 2018/9/16
 */
public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            int finalI = i;
//            new Thread() {
//                @Override
//                public void run() {
//                    TokenHolder.setToken("aaa" + finalI);
//                    String token = TokenHolder.getToken();
//                    System.out.println(token);
//                }
//            }.start();
//        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);

        for (int i = 0; i < 100; i++) {
            int i2 = i;
            CyclicBarrier cyclicBarrier1 = cyclicBarrier;
            new Thread() {
                @Override
                public void run() {
                    TokenHolder.setToken(Thread.currentThread().getName() + "-------" + i2);
                    System.out.println(Thread.currentThread().getName()+"is waiting...");
                    try {
                        cyclicBarrier1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    String token = TokenHolder.getToken();
                    System.out.println(token);
                }
            }.start();
        }


    }
}

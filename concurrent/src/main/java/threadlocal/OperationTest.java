package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-19 22:40
 **/
public class OperationTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(200);
        for (int i = 0; i < 1000; i++) {
            final int i2 = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                }
                if(i2 % 2 == 0){
                    OperationContext.getContext().setMessage("even");
                }else {
                    OperationContext.getContext().setMessage("odd");
                }
                OperationContext.getContext().setI2(i2);
                OperationContext.getContext().getLog().setTime(System.nanoTime());

                System.out.println(OperationContext.getContext().getLog());
                semaphore.release();
            });
        }
        executorService.shutdown();
    }
}

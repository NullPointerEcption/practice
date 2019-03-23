package singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 09:53
 **/
public class AppMainTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(200);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //StaticClassImpl instance = StaticClassImpl.getInstance();
                //CommonImpl commonImpl = CommonImpl.getCommonImpl();
                //DoubleCheckImpl singleTonInstance = DoubleCheckImpl.getInstance();
                //EnumImpl instance = EnumImpl.INSTANCE;
                EnumImpl2 instance = EnumImpl2.getInstance();
                System.out.println(instance);

                semaphore.release();
            });
        }
        executorService.shutdown();
    }
}

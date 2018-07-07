package other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * volatile
 */
public class App1 {

    private LongAdder v1 = new LongAdder();

    public  void v1Add() {
        for (int i = 0; i < 3000; i++) {
            v1.increment();
        }
        System.out.println("v1==" + v1.longValue());
    }


    public long getV1() {
        return v1.longValue();
    }
}

class Main {
    public static void main(String[] args) {
        App1 app1 = new App1();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                app1.v1Add();
            });
        }

        executorService.shutdown();

    }
}

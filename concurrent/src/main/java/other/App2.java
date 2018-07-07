package other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicLong简单使用
 */
public class App2 {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                System.out.println(idGenerator.nextI());
            });
        }

        executorService.shutdown();
    }
}

class IdGenerator {
    private final AtomicLong sequenceNumber = new AtomicLong(0);
    private int i;

    public long next() {
        return sequenceNumber.getAndIncrement();
    }

    public long nextI() {
        return ++i;
    }
}
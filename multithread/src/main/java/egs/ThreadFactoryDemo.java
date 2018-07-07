package egs;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo {

    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Hello" + i);
            }
            System.out.println("执行完了");
        }).start();

    }
}

package com.web.practice.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-13 22:05
 **/
@Slf4j
public class DothingTogether {
    //总共有一千次请求
    private static int totalCount = 5000;
    //最多有两百个请求同时执行
    private static int concurrentCount = 200;

    public static <T> void consume(Consumer<T> consumer, T target) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        Semaphore semaphore = new Semaphore(concurrentCount);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalCount; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    consumer.accept(target);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();
    }

}

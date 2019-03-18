package com.web.practice;

import com.web.practice.anno.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-11 20:51
 **/
@Slf4j
@ThreadUnSafe
public class MainTest {
    //总共有一千次请求
    private static int totalCount = 50000;
    //最多有两百个请求同时执行
    private static int concurrentCount = 200;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        Semaphore semaphore = new Semaphore(concurrentCount);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalCount; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();
        log.info("the count is {}", count);

    }

    private static void add() {
        count++;
    }

}

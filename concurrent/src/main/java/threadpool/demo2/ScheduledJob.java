package threadpool.demo2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用newScheduledThreadPool
 */
public class ScheduledJob {

    public static void main(String[] args) {
        Temp temp = new Temp();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        //轮训开启线程执行temp 初始化的时候延迟一秒然后执行一次
        //接下来然后轮训执行，每次间隔三秒
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(temp, 1, 3, TimeUnit.SECONDS);
    }
}

class Temp extends Thread {
    @Override
    public void run() {
        System.out.println("run");
    }
}

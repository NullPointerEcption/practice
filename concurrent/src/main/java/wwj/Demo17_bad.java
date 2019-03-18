package wwj;

import java.util.concurrent.TimeUnit;

/**
 * @description: 如果一个线程正在处于运行之中，那么即使被interrupt了，还是能继续运行
 * @author: WangYuFei
 * @create: 2019-03-18 21:06
 **/
public class Demo17_bad {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}

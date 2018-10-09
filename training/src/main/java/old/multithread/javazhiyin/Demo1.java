package old.multithread.javazhiyin;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyufei
 * @version 2018/10/09 8:29
 * @description 线程交替打印测试
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread() {
            @Override
            public void run() {
                printNum("A");
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNum("B");
            }
        };

        threadA.start();
        threadB.start();
    }

    private static void printNum(String threadName){
        int i = 0;
        while (i++<3){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 " +threadName +"打印"+i);
        }
    }

}

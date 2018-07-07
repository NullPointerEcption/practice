package interview.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 启动十个线程 每个线程顺序打印0123456789
 */
public class SeqPrint {
    public static AtomicInteger orderNum = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new PrintThread(i).start();
        }
    }
}

class PrintThread extends Thread {

    private int targetNum;


    public PrintThread(int targetNum) {
        this.targetNum = targetNum;
    }


    @Override
    public void run() {
        while (true) {
            //System.out.println(Thread.currentThread().getName() + "循环中。");
            if (SeqPrint.orderNum.intValue() == targetNum) {
                System.out.println(targetNum);
                SeqPrint.orderNum.incrementAndGet();
                break;
            }
        }
    }
}

package old.interview.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class SeqPrint2 {


    public static void main(String[] args) {
        AtomicInteger orderNum = new AtomicInteger(0);
        final HandleNums handleNums = new HandleNums(orderNum);
        for (int i = 0; i < 10; i++) {
            final int targetNum = i;
            new Thread(() -> handleNums.printAndIncr(targetNum)).start();
        }
    }
}

class HandleNums {

    private AtomicInteger orderNum;
    public HandleNums(AtomicInteger orderNum) {
        this.orderNum = orderNum;
    }

    public synchronized void printAndIncr(int targetNum) {
        while (orderNum.intValue() != targetNum) {
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "开始等待.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderNum.incrementAndGet();
        System.out.println("线程" + Thread.currentThread().getName() + "对num+1.结果为" + orderNum.intValue());
        notifyAll();
        System.out.println("线程" + Thread.currentThread().getName() + "唤醒下一个线程" );
    }
}
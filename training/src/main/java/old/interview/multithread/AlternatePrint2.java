package old.interview.multithread;

/**
 * 交替打印2
 */
public class AlternatePrint2 {


    public static void main(String[] args) {
        Object lock = new Object();
        NumberPrinter numberPrinter = new NumberPrinter(lock);
        new Thread(numberPrinter::printAdd, "thread A").start();
        new Thread(numberPrinter::printAdd, "thread B").start();
    }


}

class NumberPrinter {

    private final Object lock;

    public NumberPrinter(Object lock) {
        this.lock = lock;
    }

    private int number;

    public void printAdd() {
        synchronized (lock) {
            while (number < 100) {
                lock.notify();
                number++;
                System.out.println(Thread.currentThread().getName() + " - the number is ：" + number);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
        }
    }


}
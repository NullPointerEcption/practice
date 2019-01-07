package old.interview.multithread;

/**
 * 交替打印2
 */
public class AlternatePrint2 {


    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        new Thread(() -> {
            numberPrinter.printAdd();
        }, "thread A").start();
        new Thread(() -> {
            numberPrinter.printAdd();
        }, "thread B").start();
    }


}

class NumberPrinter {

    private int number;

    public synchronized void printAdd() {
        while (number < 1000) {
            notifyAll();
            number++;
            System.out.println(Thread.currentThread().getName() + " - the number is ：" + number);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }


}
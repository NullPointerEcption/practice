package interview.javabase;

/**
 * 编码题：设计4个线程，其中两个线程每次对i增加1，另外两个线程每次对i减少1。
 */
public class App7 {

    public static void main(String[] args) {
        Resource rsc = new Resource(100);


        for (int i = 0; i < 100; i++) {
            ThreadIncrement tInc = new ThreadIncrement(rsc);
            ThreadDecrement tDec = new ThreadDecrement(rsc);

            tInc.start();
            tDec.start();
        }


    }
}

class Resource {
    private int i;

    public Resource(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public synchronized void increment() {
        this.i++;
    }

    public synchronized void decrement() {
        this.i--;
    }
}

class ThreadDecrement extends Thread {
    private Resource resource;

    public ThreadDecrement(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        super.run();
        this.resource.decrement();
        System.out.println(Thread.currentThread().getName() + "After Decre the i is :" + resource.getI());
    }
}

class ThreadIncrement extends Thread {
    private Resource resource;

    public ThreadIncrement(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        super.run();
        this.resource.increment();
        System.out.println(Thread.currentThread().getName() + "After Incre the i is :" + resource.getI());
    }
}

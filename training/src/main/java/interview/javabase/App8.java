package interview.javabase;

class MainThread {

    //有一个子线程和一个主线程，子线程先对count自增1次，然后主线程对count自增1次；接着又回到子线程对count自增1次...如此循环50次
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        MyThread myThread = new MyThread(lock);
        myThread.start();

        //先暂停主线程，保证子线程先对count进行自增
        synchronized (lock) {
            lock.wait();
        }

        //控制循环50次
        for (int i = 0; i < 50; i++) {
            //主线程对count进行自增
            synchronized (lock) {
                count++;
                System.out.println("主线程对count自增了1");
                if (i < 49) {
                    //唤醒子线程，然后暂停主线程
                    lock.notify();
                    lock.wait();
                } else {
                    //最后一次循环时直接打断子线程，让子线程正常结束
                    myThread.interrupt();
                }
            }
        }

        System.out.println("最终count的值为 " + count);
    }
}

class MyThread extends Thread {
    private Object lock;
    public MyThread(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                //对count进行自增
                MainThread.count++;
                System.out.println("子线程对count自增了1");
                //唤醒主线程
                lock.notify();
                try {
                    //暂停子线程
                    lock.wait();
                } catch (InterruptedException e) {
                    //当主线程循环50次后会打断子线程，这是直接退出，结束子线程
                    return;
                }
            }
        }
    }
}



package wwj;

import java.util.concurrent.TimeUnit;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-18 20:11
 **/
public class Demo16 {

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        TimeUnit.SECONDS.sleep(10);
        myThread.stopGracfully();

    }

    static class MyThread extends Thread {

        private volatile boolean state = true;

        @Override
        public void run() {
            while (state) {
                System.out.println("do something");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void stopGracfully() {
            this.state = false;
        }
    }
}

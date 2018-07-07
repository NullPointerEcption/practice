package old.interview.other;

import java.util.Random;

public class VolatileTest {
    public static volatile String name = "aaa";

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new ReadVolatileThread().start();
        }
        while (true) {
            new WriteVolatileThread().start();
        }
    }
}

class ReadVolatileThread extends Thread {

    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("读取到了" + VolatileTest.name);
    }
}

class WriteVolatileThread extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VolatileTest.name = "aaa" + Math.random();
        System.out.println("写入了" + VolatileTest.name);

    }
}
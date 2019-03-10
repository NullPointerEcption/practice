package old.demos;

import java.io.File;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-07 17:13
 **/
public class DemoTest {

    private static int count = 1_000;

    //public static void main(String[] args) throws InterruptedException {
    //    CountDownLatch countDownLatch = new CountDownLatch(count);
    //    Runtogether2.runTogether(count, () -> {
    //        TimeUnit.MILLISECONDS.sleep(10);
    //        count -= 1;
    //    }, countDownLatch);
    //
    //    countDownLatch.await();
    //    System.out.println(count);
    //}

    public static void main(String[] args) throws Exception {
        //CountDownLatch countDownLatch = new CountDownLatch(1);
        //countDownLatch.countDown();
        //countDownLatch.await();
        //System.out.println("finish");

        boolean b = new File("d:/b.xml").renameTo(new File("c:/checkstyle.xml"));
        System.out.println(b);
    }

}

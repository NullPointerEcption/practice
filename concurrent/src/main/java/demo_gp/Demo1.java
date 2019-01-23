package demo_gp;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-04 14:03
 **/
public class Demo1 {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        //Thread thread = new Thread(() -> {
        //    while (!Thread.currentThread().isInterrupted()) {
        //        i++;
        //    }
        //    System.out.println(Thread.currentThread().getName() + "___" + i);
        //});
        //thread.start();
        //TimeUnit.SECONDS.sleep(5);
        //thread.interrupt();
        //Thread.interrupted();

        int i = 65535;
        Integer i2 = new Integer(65535);
        System.out.println(i == i2);

        Integer i3 = new Integer(65535);
        Integer i4 = new Integer(65535);
        System.out.println(i3 == i4);

        Integer i5 = new Integer(15);
        Integer i6 = new Integer(15);
        System.out.println(i5 == i6);

        Integer i7 = Integer.valueOf(127);
        Integer i8 = Integer.valueOf(127);
        System.out.println(i7 == i8);
    }
}

package wwj;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-18 19:16
 **/
public class Demo12 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("i am sub1");
            Thread innerThread = new Thread(() -> {
                while (true) {
                    System.out.println("i am inner");
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
        });

        thread.start();

        System.out.println("i am main");

    }
}

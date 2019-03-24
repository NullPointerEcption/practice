package wwj;

/**
 * @description: 捕获线程在运行时发生的异常
 * @author: WangYuFei
 * @create: 2019-03-24 12:47
 **/
public class Demo32 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(1 / 0);
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "  " + e.getMessage());
            }
        });
        thread.start();

    }
}

package wwj;

/**
 * @description: 让一直处于运行状态的线程中断（如果一个线程一直处于运行状体）
 * @author: WangYuFei
 * @create: 2019-03-18 20:28
 **/
public class Demo17 {

    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        threadService.execute(() -> {
            while (true) {
                System.out.println("hello");
            }
        });

        threadService.shutdown(3000);
    }


}

class ThreadService {

    private Thread executorThread;

    private boolean finished = false;

    public void execute(Runnable runnable) {
        executorThread = new Thread(() -> {
            Thread thread = new Thread(runnable);
            //设置成守护线程
            thread.setDaemon(true);

            thread.start();

            try {
                //使用join阻塞方法执行
                thread.join();
                finished = true;
            } catch (InterruptedException e) {
            }
        });

        executorThread.start();
    }

    public void shutdown(long millis) {

        long currentTimeMillis = System.currentTimeMillis();
        while (!finished) {

            if ((System.currentTimeMillis() - currentTimeMillis) >= millis) {
                System.out.println("任务执行超时，需要中断");
                executorThread.interrupt();
                break;
            }

            try {
                executorThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }

        }

        finished = false;

    }

}
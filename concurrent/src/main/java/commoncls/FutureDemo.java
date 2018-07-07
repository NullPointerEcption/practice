package commoncls;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<String> doQueryTask = new FutureTask<>(new FutureTaskDemo("doQuery"));
        ExecutorService pool = Executors.newFixedThreadPool(1);

        //submit之后可以拿到结果
        Future<?> result = pool.submit(doQueryTask);
        while (true) {
            System.out.println("还没拿到结果");
            //调用get也会等待直到子线程执行完成
            if (result.get() == null) {
                System.out.println("拿到结果了");
                break;
            }
        }

        //FutureTask对象可以调用get()异步拿到结果
        String s = doQueryTask.get();

        System.out.println(s);
    }

}

class FutureTaskDemo implements Callable<String> {

    private String data;

    public FutureTaskDemo(String data) {
        this.data = data;
    }

    @Override
    public String call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行：" + this.data + ",处理完成");
        return "complete";
    }
}

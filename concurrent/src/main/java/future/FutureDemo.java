package future;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });

        System.out.println("12121");
        String s = null;
        try {
            s = submit.get(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时了");
        }
        System.out.println(s);
        executorService.shutdown();
    }

    public static void main1(String[] args) {
//        CompletableFuture<Void> hello = CompletableFuture.runAsync(() -> {
//            System.out.println("hello");
//        });
//        try {
//            hello.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        String s = null;
        try {
            s = stringCompletableFuture.get(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时了");
//            e.printStackTrace();
        }
        System.out.println(s);


    }

}

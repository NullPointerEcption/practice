package old.java8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App2 {

    public static void main(String[] args) {

        App2 app2 = new App2();
        //  System.out.println(new App2().getPrice("hello"));
        long start = System.nanoTime();
        Future<Double> sockPrivce = app2.getPriceSupplyAsync("hello");
        System.out.println("调用方法总共耗时：" + (System.nanoTime() - start) / 1000000 + "毫秒");

        try {
            Double sockPrice = sockPrivce.get();
            System.out.println(sockPrice);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("总共耗时：" + (System.nanoTime() - start) / 1000000 + "毫秒");

    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calcPrice(String product) {
        delay();
        if(true) throw new RuntimeException("calc Exception");
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    //传统的同步方式的实现
    public double getPrice(String product) {
        return calcPrice(product);
    }

    //java8的异步方式的实现
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calcPrice(product);
                futurePrice.complete(price);
            }
            //进行异常处理 否则的话如果出现异常 异常会被限制在当前线程中最终杀死该线程 导致get方法返回的结果的客户端被永久阻塞
            catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();//开启新的线程
        return futurePrice;
    }

    //java8的异步方式的实现
    public Future<Double> getPriceSupplyAsync(String product) {
        return CompletableFuture.supplyAsync(()->{
            return  calcPrice(product);
        });

    }
}

package old.java8.chapter2;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class App2 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        Thread t2=new Thread(()->{
            System.out.println("hi......");
        });

        t.start();
        t2.start();


    }
}

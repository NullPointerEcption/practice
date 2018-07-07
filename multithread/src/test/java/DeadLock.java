import org.junit.Test;

public class DeadLock {
    private static final String resource_a ="a";
    private static final String resource_b ="b";


    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource_a){
                System.out.println(Thread.currentThread().getName()+"----获取到了-----resource_a");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_b){
                    System.out.println(Thread.currentThread().getName()+"----获取到了-----resource_b");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (resource_b){
                System.out.println(Thread.currentThread().getName()+"----获取到了-----resource_b");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (resource_a){
                    System.out.println(Thread.currentThread().getName()+"----获取到了-----resource_a");
                }
            }
        }).start();
    }
    @Test
    public void test() throws Exception {




    }


}

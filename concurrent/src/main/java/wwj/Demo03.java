package wwj;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-09 14:27
 **/
public class Demo03 {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                System.out.println("A start");
                Thread.sleep(50_000);
                System.out.println("A finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("B start");
                Thread.sleep(50_000);
                System.out.println("B finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

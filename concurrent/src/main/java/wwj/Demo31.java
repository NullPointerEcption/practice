package wwj;

import java.util.concurrent.TimeUnit;

/**
 * @description: 钩子演示使用：作用：在程序退出时可以释放资源
 * @author: WangYuFei
 * @create: 2019-03-24 12:19
 **/
public class Demo31 {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("----->ready to release source (connection,file,socket)");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println("----->clear success");
        }));

        while (true) {
            System.out.println("i am working ...");
            TimeUnit.SECONDS.sleep(2);
        }
    }
}

package java8.chapter8;

import org.junit.Test;

/**
 * Author: wangyufei
 * CreateTime:2018/03/06
 * Companion:Champion Software
 */
public class App1 {

    interface Task{
        public void execute();
    }
    public static void doSomething(Runnable r){ r.run(); }
    public static void doSomething(Task a){ a.execute(); }

    @Test
    public void method() {
        //遇到这种时候只能强转
        doSomething((Task) ()-> System.out.println("hello"));


    }
}

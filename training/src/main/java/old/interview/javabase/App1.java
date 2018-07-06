package old.interview.javabase;

import org.junit.Test;

public class App1 {
    /**
     * 测试匿名类有几个构造函数
     *
     * @throws Exception
     */
    @Test
    public void test() {
        new MyPerson() {

            {
                //匿名类的构造函数写在这里
            }

            @Override
            public void test() {

            }
        };
    }



}

abstract class MyPerson {

    public MyPerson() {

    }

    public abstract void test();
}
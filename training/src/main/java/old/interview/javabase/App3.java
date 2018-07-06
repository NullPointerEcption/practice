package old.interview.javabase;

import org.junit.Test;

public class App3 {
    /**
     * 测试子父类的方法调用
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Parent p1=new Child();
        p1.test();
    }

    @Test
    public void test1() throws Exception {

    }
}
class Parent{
    protected void test() throws Exception {
        System.out.println("parent...");
    }
}
class Child extends Parent{
    protected void test() throws Exception {
        System.out.println("child...");
    }

    /**
     * 可以定义与类名相同的方法
     * @throws Exception
     */
    protected void Child() {
    }
}

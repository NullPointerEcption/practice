package interview.javabase;

import org.junit.Test;


public class App14 {
    /**
     * 测试do-while
     */
    @Test
    public void test() throws Exception {
        int a = 0, c = 0;
        do {
            --c;
            a = a - 1;
        } while (a > 0);
        System.out.println(a + "，" + c);
    }

    @Test
    public void test1() throws Exception {
    }

}

class TestObject {
    public TestObject() {
        //return new Object();
    }
}
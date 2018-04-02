package interview.javabase;

import java.util.ArrayList;

/**
 * 编写代码导致栈溢出和堆溢出
 */
public class App11 {

    public void testHeap() {
        for (; ; ) {
            ArrayList list = new ArrayList(2000000000);
        }
    }

    int num = 1;

    public void testStack() {
        num++;
        this.testStack();
    }

    public static void main(String[] args) {
        App11 t = new App11();
        t.testHeap();
        //t.testStack();
    }
}

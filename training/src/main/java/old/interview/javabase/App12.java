package old.interview.javabase;

import org.junit.Test;

public class App12 {
    @Test
    public void test() throws Exception {
        ClassB.test();
    }
}

class ClassA {
    public static void test() throws Exception {
        System.out.println(ClassA.class.getName());
    }
}

class ClassB extends ClassA {

    public static void test() throws Exception {
        System.out.println(ClassB.class.getName());
    }
}

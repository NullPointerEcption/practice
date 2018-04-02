package interview.javabase;

import org.junit.Test;

public class App {
    /**
     * switch支持String 但是String不可以为null
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        String s = null;
        switch (s) {
            case "aaa":
                System.out.println("aaa");
                break;
            case "bbb":
                System.out.println("aaa");
                break;
            case "ccc":
                System.out.println("aaa");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

    /**
     * 对象的创建过程，非静态代码块和构造函数是一个级别的，会在同时执行
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        new Person();
    }

    /**
     * 精度测试
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
       // float a = 2.2;//精度不够精确 必须强转
        double d1 = 3D;
        double d2 = 3.3D;
    }
}

class Human {
    static {
        System.out.println("human in static");
    }


    {
        System.out.println("human in non-static");
    }

    public Human() {
        System.out.println("human constructor");
    }


}

class Person extends Human {
    static {
        System.out.println("Person in static");
    }

    {
        System.out.println("Person in non-static");
    }

    public Person() {
        System.out.println("Person constructor");
    }
}
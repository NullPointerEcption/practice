package base2019;

/**
 * <p>
 * Description:测试代码执行顺序：先执行字段初始化，再执行构造方法初始化。
 * 普通代码块和字段初始化按照顺序来执行，谁在前先执行谁
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-21 09:20
 **/
public class TestInitSequence {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass);
        System.out.println(MyClass.getI3());
    }

}

class MyClass {

    private static int i2 = 12;

    static {
        i3 = -12;
        System.out.println("i am 静态代码块");
    }

    private static int i3 = 12;

    private int i = 10;

    {
        System.out.println("i am 构造代码块");
    }

    public MyClass() {
        System.out.println("i am 构造方法");
    }

    public static int getI3() {
        return i3;
    }
}

package old.other;

/**
 * 测试abstract方法是否能够加上其他关键字
 */
public class App5 {
}
abstract class MyApp1{
    public abstract void test() throws Exception ;
    //public static abstract void test1() throws Exception ;//抽象方法必须要被子类继承 所以是属于对象级别的 必须要被new出来 而static方法是类级别的

}

class MyApp2 extends  MyApp1{

    @Override
    public synchronized void test() {

    }
}

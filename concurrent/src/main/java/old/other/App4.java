package old.other;


/**
 * 静态内部类和内部类
 */
public class App4 {

    public void test() throws Exception {

        Outer.Inner inner = new Outer.Inner();//可以的 因为属于类


        //Outer2.Inner inner1 = new Outer2.Inner();//不可以 不需使用Outer2对象来new出来
        Outer2.Inner inner2 = (new Outer2()).new Inner();//这样才可以
    }
}
class Outer {

    private static int f1;
    static class Inner {
        public void test() throws Exception {
            f1++;
        }
    }
    class Inner2 {
        public void test() throws Exception {
            f1++;//静态变量属于类级别的啦 非静态类当然也可以访问了啊
        }
    }

}
class Outer2 {

    class Inner {}

}

package old.java8.chapter9;

public class App implements A,B{
    @Override
    public void hello() {
        // Java 8中引入了一种新的语法X.super.m(…)，其中X是你希望调用的m
        //方法所在的父接口。
        B.super.hello();
    }

    public static void main(String[] args) {
        new App().hello();
    }
}
interface A{
    default void hello(){
        System.out.println("hello from A;");
    }
}
interface B{
    default void hello(){
        System.out.println("hello from B;");
    }
}
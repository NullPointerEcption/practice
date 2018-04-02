package interview.javabase2;

/**
 * 内部类和静态内部类
 */
public class App1 {

    private int age;
    private static String name;

    class InnerClass {

        private int innerAge;
        private String innerName;
        //private static String innerMember;//非静态内部类并不随外部类一起加载，只有在实例化外部类之后才会加载，所以不能有静态成员

        //内部类可以引用外部类的静态或者非静态属性和方法
        public InnerClass() {
            innerAge = age++;
            innerName = name + "123";
        }
    }

    static class StaticInnerClass {

        private int staticAge;
        private String staticName;
        private static String innerMember;

        //静态内部类只能引用外部类的静态属性和方法
        public StaticInnerClass() {
//            staticAge = age;//报错
            staticName = name;
        }
    }
}

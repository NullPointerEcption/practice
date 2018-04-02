package interview.javabase2;


import interview.javabase.TestClass;

public class App {
    /**
     * 测试protected访问级别
     *
     * @param args
     */
    public static void main(String[] args) {
        //不同包下的protected成员不能够被访问
        //new TestClass().Child()

        //不同包下的protected成员在继承并且重洗protected方法的情况下才能够被访问
//        new TestClassChild().Child();

    }
}

class TestClassChild extends TestClass {
    @Override
    protected void Child() {
        super.Child();
    }
}
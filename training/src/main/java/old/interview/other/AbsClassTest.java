package old.interview.other;

/**
 * Created by Administrator on 2018/02/19.
 * 测试abstract中能否含有private成员
 */
public abstract class AbsClassTest {
    private String name;


    public  void fun(){
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        AbsClassTest test=new AbsClassTest() {
        };
        AbsClassTest test1 =new AbsClassTest() {
            @Override
            public void fun() {
                super.fun();
            }
        };

        test.fun();
    }

}

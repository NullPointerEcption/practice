package old.interview.javabase;

/**
 * 代码块的执行顺序 类的加载过程
 */
public class App5 {


    private static App5 instance = new App5();
    public static int count1 ;
    public static int count2 = 0;
    static {
        count1++;
        count2++;
    }

    private App5() {
        count1++;
        count2++;
    }

    public static App5 getInstance() {
        return instance;
    }
}

class TestApp5 {

    public static  void main(String[] args) {

        App5.getInstance();
        System.out.println(App5.count1);
        System.out.println(App5.count2);
    }

}

package old.interview.other;

public class TestByteCode {
    public static void main(String[] args) throws Exception {
        test();
    }

    public  static void test() throws Exception {
        synchronized ("aaa"){
            System.out.println("aaaaa");
        }
    }
}

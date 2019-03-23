package singleton;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 10:05
 **/
public class EnumImpl2 {

    private EnumImpl2() {
    }

    public void method() {
        System.out.println("i am a method from enum...");
    }

    public static EnumImpl2 getInstance() {
        return Enum.INSTANCE.enumImpl2;
    }


    private enum Enum {
        INSTANCE;

        private EnumImpl2 enumImpl2;

        Enum() {
            enumImpl2 = new EnumImpl2();
        }

    }
}

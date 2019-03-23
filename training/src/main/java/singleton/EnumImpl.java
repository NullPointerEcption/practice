package singleton;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 10:05
 **/
public enum EnumImpl {
    INSTANCE;

    public void method() {
        System.out.println("i am a method from enum...");
    }
}

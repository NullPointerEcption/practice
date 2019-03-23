package base;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 15:35
 **/
public class OuterClass {
    private class InstancelnnerClass {
    }

    static class StaticinnerClass {
    }

    public static void main(String[] args) {
        (new Thread() {
        }).start();
        (new Thread() {
        }).start();
        class MethodClassl {
        }
        class MethodClass2 {
        }
    }
}

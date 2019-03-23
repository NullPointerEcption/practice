package singleton;

/**
 * <p>
 * Description:使用静态内部类实现单例
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 09:52
 **/
public class StaticClassImpl {

    private StaticClassImpl() {
    }

    private static class StaticClassHolder {
        private static StaticClassImpl staticClass = new StaticClassImpl();
    }

    public static StaticClassImpl getInstance() {
        return StaticClassHolder.staticClass;
    }
}

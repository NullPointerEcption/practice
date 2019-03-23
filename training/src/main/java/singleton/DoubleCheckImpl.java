package singleton;

/**
 * <p>
 * Description:使用双重锁来实现单例
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 09:58
 **/
public class DoubleCheckImpl {


    private DoubleCheckImpl() {

    }

    //保证内存可见性
    private volatile static DoubleCheckImpl doubleCheck;

    public static DoubleCheckImpl getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheckImpl.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheckImpl();
                }
            }
        }
        return doubleCheck;
    }

}

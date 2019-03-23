package singleton;

/**
 * <p>
 * Description:使用一般的方式实现单例
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-23 09:56
 **/
public class CommonImpl {

    private static CommonImpl commonImpl = new CommonImpl();

    public static CommonImpl getCommonImpl() {
        return commonImpl;
    }
}

package threadlocal;

/**
 * @author wangyufei
 * @date 2018/9/16
 */
public class TokenHolder {
    private static ThreadLocal<String> token = new ThreadLocal<>();

    public static void setToken(String token){
        TokenHolder.token.set(token);
    }

    public static String getToken() {
        return token.get();
    }
}

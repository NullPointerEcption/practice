package threadlocal;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-19 21:34
 **/
public class OperationContext {
    private static ThreadLocal<OperationContext> threadLocal = new ThreadLocal<>();

    private Log log;

    public OperationContext() {
        log = new Log();
        log.setTime(-1L);
        log.setI2(-1);
        log.setMessage("init message");
    }

    public static OperationContext getContext() {
        OperationContext operationContext = threadLocal.get();
        if (operationContext == null) {
            threadLocal.set(new OperationContext());
        }
        return threadLocal.get();
    }

    public void setI2(int i2) {
        this.log.setI2(i2);
    }

    public void setMessage(String message) {
        this.log.setMessage(message);
    }

    public Log getLog() {
        return this.log;
    }

}

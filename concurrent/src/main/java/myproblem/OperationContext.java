package myproblem;

public class OperationContext {
    private static ThreadLocal<OperationContext> tl = new ThreadLocal<>();

    private Log log;

    private OperationContext() {
        log = new Log();
        log.setTime(System.nanoTime());
    }

    public static OperationContext getContext() {
        OperationContext context = tl.get();
        if (context == null) {
            context = new OperationContext();
            tl.set(context);
        }
        return context;
    }

    public void setI2(int i2) {
        log.setI2(i2);
    }

    public void setDetail(String detail) {
        log.setDetail(detail);
    }

    public Log getLog() {
        return log;
    }

}

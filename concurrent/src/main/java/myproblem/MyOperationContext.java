package myproblem;

public class MyOperationContext {

    private static ThreadLocal<Log> tl = ThreadLocal.withInitial(() -> {
        Log log = new Log();
        log.setTime(System.nanoTime());
        return log;
    });

    public void setI2(int i2) {
        tl.get().setI2(i2);
    }

    public void setDetail(String detail) {
        tl.get().setDetail(detail);
    }

    public Log getLog() {
        return tl.get();
    }

}

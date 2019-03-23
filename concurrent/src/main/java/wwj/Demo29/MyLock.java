package wwj.Demo29;

import java.util.Collection;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-22 17:09
 **/
public interface MyLock {

    void lock(long timewait) throws InterruptedException, TimeOutException;

    void lock() throws InterruptedException, TimeOutException;

    void unlock();

    int getBlockedThreadSize();

    Collection<Thread> getBlockedThreads();

}

class TimeOutException extends RuntimeException {
    public TimeOutException(String message) {
        super(message);
    }
}

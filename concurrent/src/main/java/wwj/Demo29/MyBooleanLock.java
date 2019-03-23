package wwj.Demo29;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-22 17:17
 **/
public class MyBooleanLock implements MyLock {

    /**
     * true 表示被占用了 false 表示被拿走了
     */
    private Boolean isLocked;
    /**
     * 正在等待锁的所有线程
     */
    private List<Thread> threads = new ArrayList<>();
    /**
     * 当前获取到锁的线程
     */
    private Thread acquireLockThread;

    public MyBooleanLock() {
        this.isLocked = false;
    }

    @Override
    public void lock(long timewait) throws InterruptedException, TimeOutException {

    }

    @Override
    public synchronized void lock() throws InterruptedException, TimeOutException {
        while (isLocked) {
            System.out.println("thread " + Thread.currentThread().getName() + " wait for lock.");
            threads.add(Thread.currentThread());
            this.wait();
        }

        System.out.println("thread " + Thread.currentThread().getName() + " acquire lock.");
        isLocked = true;
        acquireLockThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        //只有获取到锁的线程才能去释放锁
        if (acquireLockThread == Thread.currentThread()) {
            isLocked = false;
            threads.remove(Thread.currentThread());
            this.notifyAll();
            System.out.println("thread " + Thread.currentThread().getName() + " release lock.");
        }
    }

    @Override
    public int getBlockedThreadSize() {
        return threads.size();
    }

    @Override
    public Collection<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(threads);
    }
}

package wwj;

/**
 * <p>
 * Description: 死锁测试
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-20 18:15
 **/
public class Demo23 {

    public static void main(String[] args) {
        DeadLoakDemo1 deadLoakDemo1 = new DeadLoakDemo1();
        DeadLoakDemo2 deadLoakDemo2 = new DeadLoakDemo2(deadLoakDemo1);
        deadLoakDemo1.setDeadLoakDemo2(deadLoakDemo2);

        new Thread(deadLoakDemo1::m1).start();
        new Thread(deadLoakDemo2::s2).start();
    }
}

class DeadLoakDemo1 {

    private final Object lock = new Object();

    private DeadLoakDemo2 deadLoakDemo2;

    public void setDeadLoakDemo2(DeadLoakDemo2 deadLoakDemo2) {
        this.deadLoakDemo2 = deadLoakDemo2;
    }

    public void m1() {
        synchronized (lock) {
            System.out.println("m1 ... ");
            deadLoakDemo2.s1();
        }
    }

    public void m2() {
        synchronized (lock) {
            System.out.println("m2 ... ");
        }
    }
}

class DeadLoakDemo2 {
    private final Object lock = new Object();
    private DeadLoakDemo1 deadLoakDemo1;

    public DeadLoakDemo2(DeadLoakDemo1 deadLoakDemo1) {
        this.deadLoakDemo1 = deadLoakDemo1;
    }

    public void s1() {
        synchronized (lock) {
            System.out.println("s1 ... ");
        }
    }

    public void s2() {
        synchronized (lock) {
            System.out.println("s2 ... ");
            deadLoakDemo1.m2();
        }
    }
}
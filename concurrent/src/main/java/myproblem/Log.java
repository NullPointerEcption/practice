package myproblem;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-19 18:22
 **/
public class Log {
    private int i2;
    private Long time;
    private String detail;

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {

        return Thread.currentThread().getName() + " --- Log{" +
                "i2=" + i2 +
                ", time=" + time +
                ", detail='" + detail + '\'' +
                '}';
    }
}

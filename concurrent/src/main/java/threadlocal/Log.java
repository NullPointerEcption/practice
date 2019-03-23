package threadlocal;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-19 21:32
 **/
public class Log {

    private int i2;
    private long time;
    private String message;

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        if (i2 % 2 == 0 && "odd".equals(message)) {
            return "error happened : " + "Log{" +
                    "i2=" + i2 +
                    ", time=" + time +
                    ", message='" + message + '\'' +
                    '}';
        }

        return "Log{" +
                "i2=" + i2 +
                ", time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}

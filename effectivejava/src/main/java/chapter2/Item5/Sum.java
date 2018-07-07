package chapter2.Item5;

import java.time.Instant;

public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println((System.currentTimeMillis()-s)+"毫秒");
    }
}

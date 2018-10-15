package chapter2.Item5;

public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;//由于装箱的存在会导致每调用一次+就会创建一个Long实例对象
        }
        System.out.println(sum);
        System.out.println((System.currentTimeMillis()-s)+"毫秒");
    }
}

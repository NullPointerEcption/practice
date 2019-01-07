package basic;

public class Numbers {
    public static void main(String[] args) {
        byte b = 127;
        b = (byte) (b + 1);
        System.out.println(b);//-128
        short s = 1;
        s += 1;
        System.out.println(s);//2
    }
}

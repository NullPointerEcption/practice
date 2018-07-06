package old.interview.other;

/**
 * 十进制转成二进制
 */
public class ToBinary {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(15);
        System.out.println(s);

        toBinary(17);
    }

    public static String toBinary(int n) {

        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        System.out.println(str);


        return "";
    }

}

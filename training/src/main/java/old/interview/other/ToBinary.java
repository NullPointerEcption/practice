package old.interview.other;

/**
 * 十进制转成二进制
 */
public class ToBinary {
    public static void main(String[] args) {
        toBinary(100);
        System.out.println(toBinary2(10));
    }

    public static void toBinary(int n) {

        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        System.out.println(str);
    }

    public static String toBinary2(int n) {
        String res = "";
        while (n > 0) {
            res = (n & 1) + res;
            n = n >>> 1;
        }
        return res;
    }

}

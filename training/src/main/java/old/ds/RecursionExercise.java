package old.ds;

import java.util.regex.Pattern;

/**
 * 递归练习
 *
 * @author Administrator
 */
public class RecursionExercise {
    public static void main(String[] args) {

        RecursionExercise main = new RecursionExercise();
//        System.out.println(main.fibonacci(15));
//        System.out.println(main.fionacci2(15));
//        System.out.println(main.recursiveStr("abvDEF"));

        char c1 = '0';
//        System.out.println((int)c1);

//        System.out.println(toInt("12345sdsd"));
        System.out.println(toInt2("12345"));
    }

    /**
     * 字符串转成整数
     * @param nums
     * @return
     */
    public static int toInt(String nums){
        if(nums==null|| !Pattern.compile("\\d+").pattern().matches(nums)){
            throw new IllegalArgumentException();
        }

        char[] chars = nums.toCharArray();
        int result=0,len=chars.length;
        for (int i = 0; i < chars.length; i++) {
            result+=(chars[i]-'0')*Math.pow(10,--len);
        }
        return result;
    }

    /**
     * 字符转成数字
     * @param nums
     * @return
     */
    public static int toInt2(String nums){
        if(nums==null|| !nums.matches("\\d+")){
            throw new IllegalArgumentException();
        }

        char[] chars = nums.toCharArray();
        int result=0;
        for (int i = 0; i < chars.length; i++) {
            result=result*10+(chars[i]-'0');
        }
        return result;
    }



    /**
     * 斐波那契数列
     *
     * @param num
     * @return
     */
    public int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public int fionacci2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("parameter n:" + n + " is not a valid parameter");
        }

        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        int f1 = 0;
        int f2 = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }

        return res;


    }


    public String recursiveStr(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + recursiveStr(s.substring(0, s.length() - 1));
    }

}

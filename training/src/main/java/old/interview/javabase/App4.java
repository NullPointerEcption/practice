package old.interview.javabase;

import org.junit.Test;

import java.util.Map;

public class App4 {
    /**
     * 测试protected访问级别 同一个包下的protected成员可以被访问
     *
     * @param args
     */
    public static void main(String[] args) {
        new Child().Child();
    }

    @Test
    public void test() throws Exception {
        short maxValue = Short.MAX_VALUE;
        System.out.println(maxValue);

        double f = 8.8;
    }

    /**
     * 用循环控制语句打印输出：1+3+5+...+99的结果
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        int res = 0;
        for (int i = 1; i <= 99; i += 2) {
            System.out.print(i + ((i == 99) ? "" : "+"));
            res += i;
        }
        System.out.println("=" + res);
    }

    /**
     * castException
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Object o = new Object();
        o = (Map) o;
    }

    /**
     * 给你 一组字符串如“abc1f0ff9aaa8rr4”，编程输出里面的数字：10984
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        System.out.println(((int) '0'));

        String s = "abc1f0ff9aaa8rr4";
        StringBuilder res=new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>=48&&chars[i]<=57){
                res.append(chars[i]);
            }
        }
        System.out.println(res);
    }
}

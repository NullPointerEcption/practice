package old.interview.other;

import org.junit.Test;

public class AutoBoxing {

    @Test
    public void test1() throws Exception {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 322;
        Long g = 3L;
        int[] nums = {1, 2, 3};

        //FIXME ==在没有遇到算术运算符的情况下不会拆箱 equals方法不会处理数据转型关系
        System.out.println(c == d);//t
        System.out.println(e + 1 == f);//t
        System.out.println(c == (a + b));//t
        System.out.println(c.equals(a + b));//t
        System.out.println(g == a + b);//t 反编译成 g.longValue == a.intValue+b.intValue
        System.out.println(g.equals(a + b));//f 反编译成g.equals(Integer.valueOf(a.intValue+b.intValue))
    }

    @Test
    public void test() throws Exception {
        Integer i1 = 1;
        Long i2 = 1L;
        // System.out.println(i1 == i2);//会报错
    }
}

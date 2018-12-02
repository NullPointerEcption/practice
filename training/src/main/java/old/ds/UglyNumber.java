package old.ds;

import org.junit.Assert;
import org.junit.Test;

/**
 * 丑数 只能被2,3,5整除的数 1是第一个丑数
 */
public class UglyNumber {

    public boolean isUglyNum(int n) throws Exception {

        if (n <= 0) {
            throw new IllegalArgumentException("无法判断" + n + "是否为丑数");
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }

    /**
     * 查找第几个丑数 1是第一个丑数
     * @param index 第几个
     * @return
     * @throws Exception
     */
    public int findUglyNum(int index) throws Exception {
        if (index <= 0) {
            throw new IllegalArgumentException();
        }

        int uglyNumber = 0;
        int count = 0;
        while (count < index) {
            uglyNumber++;
            if (isUglyNum(uglyNumber)) {
                count++;
            }
        }

        return uglyNumber;
    }

    @Test
    public void testIsUglyNumber() throws Exception {
        Assert.assertEquals(isUglyNum(2), true);
        Assert.assertEquals(isUglyNum(6), true);
        Assert.assertEquals(isUglyNum(7), false);
    }

    @Test
    public void testFind() throws Exception {
        System.out.println(findUglyNum(2));
        System.out.println(findUglyNum(3));
        System.out.println(findUglyNum(4));
        System.out.println(findUglyNum(5));
        System.out.println(findUglyNum(6));
        System.out.println(findUglyNum(7));
        System.out.println(findUglyNum(8));
        System.out.println(findUglyNum(9));
        System.out.println(findUglyNum(10));
        System.out.println(findUglyNum(11));
        System.out.println(findUglyNum(12));
        System.out.println(findUglyNum(13));
    }

}

package ds;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:wangyufei
 * CreateTime: 2018/7/6
 */
public class HappyNum {

    /**
     * 判断一个数字是否为快乐数字
     * Function: 判断一个数字是否为快乐数字 19 就是快乐数字  11就不是快乐数字
     * 19
     * 1*1+9*9=82
     * 8*8+2*2=68
     * 6*6+8*8=100
     * 1*1+0*0+0*0=1
     *
     * 11
     * 1*1+1*1=2
     * 2*2=4
     * 4*4=16
     * 1*1+6*6=37
     * 3*3+7*7=58
     * 5*5+8*8=89
     * 8*8+9*9=145
     * 1*1+4*4+5*5=42
     * 4*4+2*2=20
     * 2*2+0*0=2
     *
     * 这里结果 1*1+1*1=2 和 2*2+0*0=2 重复，所以不是快乐数字
     *
     * @param num 带判断的数字
     * @return
     */
    public static boolean isHappyNum(int num) {
        if (num < 10) {
            return true;
        }
        Set<Integer> caledRes = new HashSet<>();
        int tempRes = 0;
        while (num != 1) {
            while (num > 0) {
                tempRes += (int) Math.pow(num % 10, 2);
                num /= 10;
            }
            if(!caledRes.contains(tempRes)){
                caledRes.add(tempRes);
            }else{
                return false;
            }
            num = tempRes;
            tempRes = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNum(19));
    }
}

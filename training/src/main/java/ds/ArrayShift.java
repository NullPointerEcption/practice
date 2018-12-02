package ds;

import java.util.Arrays;

/**
 * @author wangyufei
 * @date 2018/10/9
 * 将数组向右移动k次 如【1，2，3，4，5，6，7】 右移三次变成【5，6，7，1，2，3，4】
 */
public class ArrayShift {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int moveIndex = array.length - k;

        //先把数组反转一遍 变成 7 6 5 4 3 2 1
        reverseArray(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        //前k个元素反转回来 5 6 7 4 3 2 1
        reverseArray(array, 0, k - 1);
        System.out.println(Arrays.toString(array));

        //后面的len- k 个元素再反转回来 5 6 7 1 2 3 4
        reverseArray(array, k, array.length - 1);
        System.out.println(Arrays.toString(array));


    }

    public static void reverseArrayCore(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1];
            array[array.length - 1] = temp;
        }
    }

    public void reverseArray2(int[] array, int startIndex, int endIndex) {
        //截取数组 //反转
    }


    /**
     * 反转数组
     *
     * @param array 数组
     */
    private static void reverseArray(int[] array, int startIndex, int endIndex) {
        int eIndex = 0;
        for (int i = startIndex; i < (startIndex + (endIndex - startIndex) / 2 + 1); i++) {
            int temp = array[i];
            array[i] = array[endIndex - eIndex];
            array[endIndex - eIndex] = temp;
            eIndex++;
        }
    }

}

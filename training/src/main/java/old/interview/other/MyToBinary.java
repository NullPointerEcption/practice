package old.interview.other;

import java.util.Arrays;

/**
 * 我自己的一些算法练习
 */
public class MyToBinary {
    public static void main(String[] args) {
        //System.out.println(toBinary(10));

        bubbleSort(new int[]{1, 5, 4, 3, 55, 6, 7});
    }

    public static String toBinary(int num) {
        String result = "";

        while (num != 0) {
            result = num % 2 + result;
            num = num / 2;
        }
        return result;
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int temp = nums[j];
                if (temp > nums[j + 1]) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}



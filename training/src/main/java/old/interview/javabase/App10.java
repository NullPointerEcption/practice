package old.interview.javabase;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class App10 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 22, 3, 4, 44, 5, 6, 55, 7, 33, 8, 9};
        sortBupple(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortBupple(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = arr[i];
                }
            }
        }
    }
}

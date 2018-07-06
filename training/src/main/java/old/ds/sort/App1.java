package old.ds.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 时间复杂度（平均）	时间复杂度（最坏)	时间复杂度（最好)	空间复杂度
 */
public class App1 {

    int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

    public void printA() throws Exception {
        System.out.println(Arrays.toString(a));
    }

    /**
     * 使用直接插入排序将数组a重新排序 O(n2)	O(n2)	O(n)	O(1)
     *
     * @throws Exception
     */
    @Test
    public void insertionSort() throws Exception {

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
        printA();
    }


    /**
     * 冒泡排序 	O(n2) 	O(n2)	O(n)	O(1)
     *
     * @throws Exception
     */
    @Test
    public void bubbleSort() throws Exception {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length - i - 1; j++)
            {
                // 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        printA();
    }

    /**
     * 选择排序 O(n2)	O(n2)	O(n2)	O(1)
     *
     * @throws Exception
     */
    @Test
    public void selectionSort() throws Exception {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {
                    minIndex = j;
                    temp = a[j];
                }
            }
            a[minIndex] = a[i];
            a[i] = temp;
        }

        printA();
    }

}

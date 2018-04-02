package interview.javabase;

/**
 * 编写代码，找出int数组arr1[]和arr2[]中都包含的数字有几个，并计算出执行该过程所花费的时间
 */
public class App9 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] arr2 = {22, 3, 4, 6, 89, 54, 68, 434};

        long start = System.nanoTime();
        int n = getSameItemsSize(arr1, arr2);
        System.out.println("耗时:" + (System.nanoTime() - start)/1_000_000F + "毫秒");
        System.out.println(n);
    }

    private static int getSameItemsSize(int[] arr1, int[] arr2) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    res++;
                    break;
                }
            }

        }
        return res;
    }
}

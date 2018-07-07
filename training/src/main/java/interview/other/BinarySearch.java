package interview.other;

import org.junit.Test;

public class BinarySearch {

    @Test
    public void test() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 7;
        int low = 0;
        int high = nums.length - 1;

        while (high >= low) {
            int middle = (high + low) / 2;
            if (nums[middle] == n) {
                System.out.println("下标为：" + middle);
                break;
            } else {
                if (nums[middle] > n) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }
}

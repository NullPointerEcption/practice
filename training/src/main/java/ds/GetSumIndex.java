package ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyufei
 * @version 2018/07/07 13:07
 * @description 从一个数组中返回两个值相加等于目标值的下标
 */
public class GetSumIndex {

    static int[] targetArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int targetNum = 15;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getTargetIndex(targetArray, targetNum)));
        System.out.println(Arrays.toString(getTargetIndex2(targetArray, targetNum)));
        System.out.println(Arrays.toString(getTwo2(targetArray, targetNum)));
    }

    /**
     * 笨方法
     *
     * @param targetArray
     * @param targetNum
     * @return
     */
    private static int[] getTargetIndex(int[] targetArray, int targetNum) {
        int[] arrOfIndex = new int[2];

        arrOfIndex[1] = -1;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < targetArray.length; i++) {
            numMap.put(i, targetArray[i]);
            arrOfIndex[0] = i;

            int balance = targetNum - targetArray[i];
            if (numMap.containsValue(balance)) {
                //从map中获取值为balance对应的key最小的那个entrySet
                Map.Entry<Integer, Integer> balanceMap = numMap.entrySet().stream()
                        .filter(m -> m.getValue() == balance)
                        .min(Comparator.comparingInt(Map.Entry::getKey))
                        .get();
                arrOfIndex[1] = balanceMap.getKey();
                break;
            } else {
                continue;
            }
        }
        if (arrOfIndex[1] == -1) {
            throw new RuntimeException("目标值无法在数组中通过元素组合而成");
        }
        return arrOfIndex;
    }

    /**
     * 保存余数方法
     *
     * @param targetArray
     * @param targetNum
     * @return
     */
    private static int[] getTargetIndex2(int[] targetArray, int targetNum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < targetArray.length; i++) {

            int balance = targetNum - targetArray[i];
            if (map.containsKey(balance)) {
                return new int[]{map.get(balance), i};
            }
            map.put(targetArray[i], i);
        }
        return new int[]{};
    }

    /**
     * crossoverjie的做法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwo2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                result = new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}

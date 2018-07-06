package old.java8.chapter13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

    @Test
    public void test() throws Exception {
        List<Integer> integers = Arrays.asList(1, 4, 9);
        List<List<Integer>> allSets = getSubSets(integers);
        allSets.stream().map(l -> l.toArray(new Integer[l.size()]))
                .forEach(a -> System.out.println(Arrays.toString(a)));
    }

    /**
     * 得到一个集合下的所有子集
     * eg:
     * 传入：{1,4,9}
     * 返回：{},{4},{9},{4,9},{1},{1,4},{1,9},{1,4,9}
     *
     * @param list
     * @return
     */
    private List<List<Integer>> getSubSets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> subList = list.subList(1, list.size());

        List<List<Integer>> subPart = getSubSets(subList);
        List<List<Integer>> subPart2 = insertAll(first, subPart);

        return concat(subPart, subPart2);
    }

    private List<List<Integer>> concat(List<List<Integer>> subPart, List<List<Integer>> subPart2) {
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(subPart);
        res.addAll(subPart2);
        return res;
    }

    private List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> items : lists) {
            List<Integer> copyList=new ArrayList<>();
            copyList.add(first);
            copyList.addAll(items);
            res.add(copyList);
        }

        return res;
    }
}

package week193;

import java.util.*;

/**
 * 5437. 不同整数的最少数目
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/least-number-of-unique-integers-after-k-removals/
 */
public class lc5437 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 总的不同整数个数
        int cntVal = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (!map.containsKey(val)) {
                cntVal++;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println(cntVal);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        List<Integer> list = new ArrayList<>();
        for (int val : map.keySet()) {
            // 存储个数
            list.add(map.get(val));
        }
        Collections.sort(list);
        for (int val : list) {
//            System.out.println(val);
            k -= val;
            if (k < 0) {
                break;
            }
            cntVal--;
        }
        return cntVal;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 4};
        System.out.println(findLeastNumOfUniqueInts(arr, 1));
    }
}

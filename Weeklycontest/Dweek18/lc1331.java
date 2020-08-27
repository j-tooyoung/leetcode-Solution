package Dweek18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * https://leetcode-cn.com/contest/biweekly-contest-18/problems/rank-transform-of-an-array/
 */
public class lc1331 {

    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int[] newArr = Arrays.copyOf(arr, len);
        Arrays.sort(newArr);
        Map<Integer, Integer> map = new HashMap<>();
        int cntRepet = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(newArr[i])) {
                cntRepet++;
                continue;
            }
            if (cntRepet > 0) {
                map.put(newArr[i], i-cntRepet+1);
            } else {
                map.put(newArr[i], i + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

}

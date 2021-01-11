package week108;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc930
 * @Description
 * @Date 2021/1/11 14:47
 * @Created by j-tooyoung
 */
public class lc930 {

    public int numSubarraysWithSum(int[] A, int S) {
        int len = A.length;
        int[] pre = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + A[i];
            res += map.getOrDefault(pre[i + 1] - S, 0);
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }

        return res;
    }
}

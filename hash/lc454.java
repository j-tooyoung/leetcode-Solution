import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc454
 * @Description 454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 * @Date 2020/10/5 6:42
 * @Created by j-tooyoung
 */
public class lc454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
}

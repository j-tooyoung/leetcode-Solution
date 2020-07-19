import java.util.HashMap;
import java.util.Map;

/**
 * 1394. 找出数组中的幸运数
 * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 */
public class lc1394 {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int res = -1;
        for (int val : map.keySet()) {
            if (map.get(val) == val) {
                res = Math.max(res, val);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

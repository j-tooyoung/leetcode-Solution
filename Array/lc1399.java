import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1399. 统计最大组的数目
 * https://leetcode-cn.com/problems/count-largest-group/
 */
public class lc1399 {

    public static int countLargestGroup(int n) {
        return 0;
    }

        // 太慢
    public static int countLargestGroup1(int n) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int digitSum = bitOfSum(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
            res = Math.max(res, map.get(digitSum));
        }
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int cnt = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == res) {
                ++cnt;
            }
        }
        return cnt;
    }

    private static int bitOfSum(int i) {
        int res = 0;
        while (i != 0) {
            res += (i % 10);
            i /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(bitOfSum(13));

    }

}

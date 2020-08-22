import java.util.HashMap;
import java.util.Map;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 */
public class lc1010 {

    // 有待优化
    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int val = time[i] % 60;
            int tmp = val == 0 ? 0 : 60 - val;
            if (map.containsKey(tmp)) {
                res += map.get(tmp);
            }
            map.put(val, map.getOrDefault(val,0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

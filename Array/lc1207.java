import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class lc1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
//         Set<Integer> integers = map.keySet();
        for (int val : map.keySet()) {
            int cnt = map.get(val);
            if (set.contains(cnt)) {
                return false;
            }
            set.add(cnt);
        }
        return true;
    }

}

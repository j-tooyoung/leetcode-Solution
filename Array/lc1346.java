import java.util.HashMap;
import java.util.Map;

/**
 * 1346. 检查整数及其两倍数是否存在
 * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
 *
 */
public class lc1346 {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && map.containsKey(arr[i] / 2)) || map.containsKey(arr[i] * 2)) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

}

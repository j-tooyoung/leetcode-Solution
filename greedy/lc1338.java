import java.util.*;

/**
 * @Classname lc1338
 * @Description TODO
 * @Date 2020/8/25 20:18
 * @Created by xp123
 * 1338. 数组大小减半
 * https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
 *
 */
public class lc1338 {

    public int minSetSize(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int val = arr[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int target = len / 2;
        int cnt = 0;
//        int[] num = new int[map.size()];
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        int delLen = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (delLen >= target) {
                return cnt;
            } else {
                delLen += list.get(i);
                cnt++;
            }
        }
        return cnt;
    }

}

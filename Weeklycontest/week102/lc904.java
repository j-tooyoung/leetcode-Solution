package week102;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname lc904
 * @Description
 * @Date 2021/1/14 11:13
 * @Created by j-tooyoung
 */
public class lc904 {

    // 超时
    public int totalFruit(int[] tree) {
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            Set<Integer> set = new HashSet<>();
            int j = i;
            while (j < tree.length ) {
                set.add(tree[j]);
                if (set.size() >= 3) {
                    break;
                }
                j++;
            }
            max = Math.max(max, j - i);
            // System.out.println(i + " " + j);

        }
        return max;
    }

    public int totalFruit1(int[] tree) {
        int max = 0;
        for (int i = 0; i < tree.length;) {
            Map<Integer, Integer> map = new HashMap<>();
            int j = i;
            while (j < tree.length) {
                map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
                if (map.size() >= 3) {
                    break;
                }
                j++;
            }
            max = Math.max(max, j - i);
            while (map.size() >= 2) {
                int cnt = map.get(tree[i]);
                if (cnt == 1) {
                    map.remove(tree[i]);
                } else {
                    map.put(tree[i], cnt - 1);
                }
                i++;
            }
            // System.out.println(i + " " + j);

        }
        return max;
    }
}

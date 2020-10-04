package week209;

import java.util.HashMap;
import java.util.Map;

/**
 * 5531. 特殊数组的特征值
 */
public class lc5531 {

    public int specialArray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int[] cnt = new int[maxVal + 1];
        cnt[maxVal] = map.getOrDefault(maxVal, 0);
        if (maxVal == cnt[maxVal]) return maxVal;
        for (int i = maxVal - 1; i >= 0; i--) {
            cnt[i] = cnt[i + 1] + map.getOrDefault(i, 0);
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }

}

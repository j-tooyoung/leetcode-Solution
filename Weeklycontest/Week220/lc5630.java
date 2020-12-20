package Week220;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5630 {

    public int maximumUniqueSubarray(int[] nums) {
        int res = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) != 1) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                sum -= nums[left];
                left++;
            }
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}

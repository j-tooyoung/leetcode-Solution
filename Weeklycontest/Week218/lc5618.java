package Week218;

import java.util.Arrays;

/**
 * @Classname lc5664
 * @Description
 * @Date 2020/11/15 23:43
 * @Created by j-tooyoung
 */
public class lc5618 {


    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int ans = 0;
        while (lo < hi) {
            long total = (long) nums[lo] + nums[hi];
            if (total < k) {
                lo++;
            } else if (total == k) {
                ans++;
                lo++;
                hi--;
            }else{
                hi--;
            }
        }
        return ans;
    }
}

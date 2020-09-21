package Dweek35;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5505
 * @Description TODO
 * @Date 2020/9/19 22:48
 * @Created by xp123
 * 5505. 所有排列中的最大和
 */
public class lc5505 {

//    统计每个位置被覆盖的次数，按照次数的高低依次分配数字，次数和数字相乘。
//    统计被覆盖次数可以采用差分，然后求前缀和的方式。
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int res = 0;
        int mod = 1000_000_007;
        int len = nums.length;
        int[] cnt = new int[len];
        for (int[] val : requests) {
            cnt[val[0]]++;
            if (val[1] + 1 < len) {
                cnt[val[1] + 1]--;
            }
        }
        for (int i = 1; i < len; i++) {
            cnt[i] += cnt[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(cnt);
        for (int i = 0; i < len; i++) {
            res = (int) ((res + (long) (nums[i]) * cnt[i]) % mod);
        }
        return res;
    }
}

package Week204;

/**
 * @Classname lc5500
 * @Description TODO
 * @Date 2020/8/30 10:35
 * @Created by xp123
 * 5500. 乘积为正数的最长子数组长度
 * https://leetcode-cn.com/contest/weekly-contest-204/problems/maximum-length-of-subarray-with-positive-product/
 */
public class lc5500 {

    // 暴力法
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int[] multi = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) continue;
            for (int j = i; j < len; j++) {

                if (isPositive(nums, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private boolean isPositive(int[] nums, int i, int j) {
        int total = 1;
        int cnt = 0;
        for (int k = i; k <= j; k++) {
//total *=
            if (nums[k] == 0 ) return false;
            if (nums[k] < 0) cnt++;
        }
        return cnt % 2 == 0;
    }

    public int getMaxLen1(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                dp[i] = 0;
            } else if (nums[i] < 0) {
                int start = 0;
                int cnt = 0;
                int neg = 0;
                while (start >= 0 && nums[start] != 0) {
                    cnt++;
                    if (nums[start] < 0) neg++;
                    start--;
                }
//                dp[i] = neg % 2 == 0 ? cnt : cnt ;
            } else {

            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}

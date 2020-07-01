/**
 * ClassName: lc673
 * Package: PACKAGE_NAME
 * Description:
 * 673. 最长递增子序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 * @date: 2020/4/8 23:02
 * @author: tooyoung
 */

public class lc673 {

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int maxVal = 1;
        int res = 0;
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //第一次找到组合
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //再次找到
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxVal = Math.max(dp[i], maxVal);
        }
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxVal) {
                res += cnt[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int[] nums1 = {2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums));
        System.out.println(findNumberOfLIS(nums1));

    }

}

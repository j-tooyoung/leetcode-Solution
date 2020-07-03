/**
 * ClassName: lc416
 * Package: PACKAGE_NAME
 * Description:
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @date: 2020/4/8 23:01
 * @author: tooyoung
 */

public class lc416 {

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int val : nums) {
            total += val;
        }
        if ((total & 1) != 0){ return false;}
        total = total / 2 + 1;
//        System.out.println(total);
        boolean[] dp = new boolean[total];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = total - 1; j >= nums[i]; j--) {
                if (dp[total - 1]) return true;
                dp[j] = dp[j] || dp[j - nums[i]];
//                System.out.println(dp[j]);
            }
        }
        return dp[total - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums1 = {1, 2, 5};
//        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums1));

    }
}

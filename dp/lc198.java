/**
 * ClassName: lc198
 * Package: PACKAGE_NAME
 * Description:
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @date: 2020/4/8 22:58
 * @author: tooyoung
 */

public class lc198 {

    public static int rob(int[] nums) {
        int len = nums.length;
//        if (len == 1) return nums[0];
//        if (len == 2) return Math.max(nums[1], nums[0]);
        int[] dp = new int[nums.length];
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
//            dp[i] = Math.max(Math.max(dp[i], dp[i - 1]), dp[i - 2] + nums[i]);  错误
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
//        return dp[len - 1];  错误

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        int[] nums3 = {1};
        int[] nums4 = {1, 3};
        int[] nums5 = {1, 3, 5};
        int[] nums6 = {2, 1, 1, 2};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
        System.out.println(rob(nums4));
        System.out.println(rob(nums5));
        System.out.println(rob(nums6));

    }

}

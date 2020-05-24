package week190;

/**
 * 5419. 两个子序列的最大点积
 * https://leetcode-cn.com/contest/weekly-contest-190/problems/max-dot-product-of-two-subsequences/
 *
 */
public class lc5419 {


    // some problem?
    public static int maxDotProduct(int[] nums1, int[] nums2) {
//        int l1 = nums1.length, l2 = nums2.length;
//        int[][] dp = new int[l1 + 1][l2 + 1];
//
//        for (int i = 1; i <= l1; i++) {
//            for (int j = 1; j <= l2; j++) {
//                // 都选,都不选
//                dp[i][j] = dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1];
//                if (i > 1 && j > 1) dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
//                // 选nums1[i]
//                for (int k = 1; k < j; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k - 1] + nums1[i - 1] * nums2[k - 1]);
//                }
//                //选num2[j]
//                for (int k = 1; k < i; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[k - 1][j - 1] + nums1[k - 1] * nums2[j - 1]);
//                }
//            }
//        }
//        return dp[l1][l2];
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums1 = {2, 1, -2, 5};
        int[] nums1 = {-1, -1};
        int[] nums2 = {1, 1};
//        int[] nums2 = {3, 0, -6};
        System.out.println(maxDotProduct(nums1, nums2));
    }
}

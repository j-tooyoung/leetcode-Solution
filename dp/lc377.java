import java.util.Arrays;

/**
 * ClassName: lc377
 * Package: PACKAGE_NAME
 * Description:
 * 377. 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 *
 * 题解
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
 *
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
 *
 * @date: 2020/4/8 23:01
 * @author: tooyoung
 */

public class lc377 {

    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
//                    System.out.println(dp[i]);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums1 = {1, 2};
        System.out.println(combinationSum4(nums, 4));
        System.out.println(combinationSum4(nums1, 2));
    }

}

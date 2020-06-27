import java.util.Arrays;

/**
 * ClassName: lc698
 * Package: PACKAGE_NAME
 * Description:
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 *
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/solution/javadai-fan-hui-zhi-de-hui-su-fa-by-caipengbo/
 * @date: 2020/4/8 23:02
 * @author: tooyoung
 */

public class lc698 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        int target = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int val : nums) {
            total += val;
            maxVal = Math.max(maxVal, val);
        }
        target = total / k;
        if (total %k != 0 || maxVal > target) return false;
        return dfs(nums, target, 0, 0, new boolean[nums.length],  k);
    }

    private static boolean dfs(int[] nums, int target, int cur, int start, boolean[] used,  int k) {

        if (k == 0 ) {
            return true;
        }
        if (cur > target) return false;
        if (target == cur) {
            return dfs(nums, target, 0, 0, used, k - 1);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                //找到其中一个结果就返回
                if (dfs(nums, target, cur + nums[i], i + 1, used, k)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}

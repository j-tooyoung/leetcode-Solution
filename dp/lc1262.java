import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1262. 可被三整除的最大和
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 */
public class lc1262 {

    // 状态机
    public int maxSumDivThree1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
//        初始状态？？？
        for (int i = 0; i < 3; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][0] + nums[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][1] + nums[i]);
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][2] + nums[i]);
            } else if (nums[i] % 3 == 1) {
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + nums[i]);
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][1] + nums[i]);
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][2] + nums[i]);
            } else {
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][0] + nums[i]);
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + nums[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][2] + nums[i]);
            }
        }
//        System.out.println(dp[n - 1][0] + " " + dp[n - 1][1] + " " + dp[n - 1][2]);
        for (int[] arr : dp) {
            Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
        return dp[n][0];
    }

    // 超时
//    Map<Integer, Integer> map;

    public int maxSumDivThree(int[] nums) {
//        map = new HashMap<>();
        return dfs(nums, 0, 0, new boolean[nums.length]);
    }

    private int dfs(int[] nums, int idx, int sum, boolean[] used) {

        if (idx >= nums.length) {
            return sum;
        }
//        if (map.containsKey(idx)) {
//            return map.get(idx);
//        }
        int a = dfs(nums, idx + 1, sum + nums[idx], used);
        int b = dfs(nums, idx + 1, sum, used);
        a = (a % 3) != 0 ? 0 : a;
        b = (b % 3) != 0 ? 0 : b;
//        map.put(idx, Math.max(a, b));
        return Math.max(a, b);
    }

    public static void main(String[] args) {

    }

}

import java.util.Arrays;

/**
 * ClassName: lc53
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:56
 * @author: tooyoung
 */

public class lc53 {


    public int maxSubArray(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {

    }

}

import java.util.Map;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class lc1413 {

    public int minStartValue(int[] nums) {
        int len = nums.length;
        int[] res = new int[len + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res[i + 1] = res[i] + nums[i];
            ans = Math.min(ans, res[i + 1]);
        }
        return ans < 0 ? -ans + 1 :1;
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class lc1403 {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int total = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        int curSum = 0;
        for (int i = len - 1; i >= 0; i--) {
            curSum += nums[i];
            res.add(nums[i]);
            if (curSum > total - curSum) {
                break;
            }
        }
        return res;
    }
}

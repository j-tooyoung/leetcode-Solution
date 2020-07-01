/**
 * ClassName: lc300
 * Package: PACKAGE_NAME
 * Description:
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @date: 2020/4/8 22:59
 * @author: tooyoung
 */

public class lc300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int res = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //时间复杂度nlogn
//   新建数组 cell，用于保存最长上升子序列。
//    对原序列进行遍历，将每位元素二分插入 cell 中。
//    如果 cell 中元素都比它小，将它插到最后
//    否则，用它覆盖掉比它大的元素中最小的那个。

    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for (int num : nums) {
            int lo = 0, hi = res;
            while (lo < hi) {
                int mid = lo + hi >> 1;
                if (dp[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = num;
            //如果是放在元素最后，长度加1
            if (lo == res) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

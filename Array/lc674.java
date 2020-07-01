/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class lc674 {
    public static int findLengthOfLCIS(int[] nums) {
        int cnt = 1;
        if (nums == null || nums.length < 1) return 0;
        int res = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int[] nums1 = {2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS(nums1));
    }

}

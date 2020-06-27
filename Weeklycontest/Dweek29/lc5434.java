package Dweek29;

import java.util.ArrayList;
import java.util.List;

/**
 * 5434. 删掉一个元素以后全为 1 的最长子数组
 * https://leetcode-cn.com/contest/biweekly-contest-29/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class lc5434 {

    public static int longestSubarray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) continue;
            int lo = i - 1, hi = i + 1;
            while (lo >= 0 && nums[lo] == 1) {
                lo--;
            }
            while (hi < len && nums[hi] == 1) {
                hi++;
            }
            //减去自身
            res.add(hi - lo - 2);
//            System.out.println(hi - lo - 2);
        }
        int ans = Integer.MIN_VALUE;
        if (res.size() < 1) return len - 1;
//        for (int val : res) {
//            ans = Math.max(ans, val);
//        }
//        return ans;
        return res.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        System.out.println(longestSubarray(nums));

    }
}

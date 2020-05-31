package week191;

import java.util.Arrays;

/**
 * 5424. 数组中两元素的最大乘积
 * https://leetcode-cn.com/contest/weekly-contest-191/problems/maximum-product-of-two-elements-in-an-array/
 */
public class lc5424 {
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                res = Math.max(res, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return res;
    }

    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[0] - 1) * (nums[1] - 1), (nums[len - 2] - 1) * (nums[len - 1] - 1));

    }

    public static void main(String[] args) {


    }

}

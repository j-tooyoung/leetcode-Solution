package week201;

import java.util.HashMap;
import java.util.Map;

/**
 * 5471. 和为目标值的最大数目不重叠非空子数组数目
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class lc5471 {

    // 贪心
    public static int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prev = 0;
        map.put(0, 0);
        for (int i = 0; i <len; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int val = sum[i + 1] - target;
            if (map.containsKey(val) && map.get(val) >= prev) {
                res++;
                prev = i+1;
            }
            map.put(sum[i + 1], i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int[] nums1 = {-2,6,6,3,5,4,1,2,8};
        int[] nums2 = {-1,3,5,1,4,2,-9};
        int[] nums3 = {1,1,1,1,1};
        int[] nums4 = {3, 0, 2, 0, 2, 3, 3, 0, 0, 2, 1, 1, 1, 0, -1, -1, 1, -1, 1, 0, 2, 0, 0, 3, 0, 0, 3, 1, 0, 2, 0, -1, 2, -1, 1, 1, 3, 0, 2, 3, 3, 0, 0, 2, -1, 1};
        System.out.println(maxNonOverlapping(nums,0));
        System.out.println(maxNonOverlapping(nums1,10));
        System.out.println(maxNonOverlapping(nums2,6));
        System.out.println(maxNonOverlapping(nums3,2));
        System.out.println(maxNonOverlapping(nums4,3));
    }

}

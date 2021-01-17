package week187;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname lc1438
 * @Description
 * @Date 2021/1/15 13:18
 * @Created by j-tooyoung
 */
public class lc1438 {

    // 滑动窗口
    public int longestSubarray(int[] nums, int limit) {
        int lo = 0;
        int hi = 0;
        int ans = 0;
        PriorityQueue<Integer> minq = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
        int len = nums.length;
        while (hi < len) {
            minq.add(nums[hi]);
            maxq.add(nums[hi]);
            hi++;
            while (lo< len && !maxq.isEmpty() && !minq.isEmpty() && maxq.peek() - minq.peek() > limit) {
                minq.remove(nums[lo]);
                maxq.remove(nums[lo]);
                lo++;
            }
            // System.out.println(lo + " " + hi +" " +  nums[lo] + " " + nums[hi]);
            ans = Math.max(ans, hi - lo);
        }
        return ans;
    }

    // brute force
    public int longestSubarray1(int[] nums, int limit) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            int j = i;
            for ( ; j < nums.length; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                if (maxVal - minVal > limit) {
                    System.out.println(i + " " + j + " " + nums[i] + " " + nums[j]);
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
            if (j == nums.length) {
                 ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}

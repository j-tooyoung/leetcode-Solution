package Week217;

import java.util.PriorityQueue;

/**
 * @Classname lc5774
 * @Description
 * @Date 2020/11/22 18:11
 * @Created by j-tooyoung
 */
public class lc5616 {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        int ans = Integer.MAX_VALUE;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
        }
        ans = maxVal - minVal;

        return ans;
    }
}

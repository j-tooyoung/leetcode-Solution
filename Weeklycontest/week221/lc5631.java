package week221;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5631 {

    // 堆优化dp
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[]{nums[0], 0});
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            while (i - pq.peek()[1] > k) {
                pq.poll();
            }
            dp[i] = dp[pq.peek()[1]] + nums[i];
            pq.add(new int[]{dp[i], i});
        }
        return dp[len - 1];
    }

    public int maxResult1(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new LinkedList<>();
        dp[0] = nums[0];
        deque.addFirst(0);
        // 队首为最大值，单调递减，队尾入队，单调队列
        for (int i = 1; i < len; i++) {
            // 队首的 j 不满足限制
            while (!deque.isEmpty() && i - deque.getFirst() > k) {
                deque.pollFirst();
            }
            dp[i] = dp[deque.getFirst()] + nums[i];
            // 队尾的 j 不满足单调性
            while (!deque.isEmpty() && dp[deque.getLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        return dp[len - 1];
    }

}

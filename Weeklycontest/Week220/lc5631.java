package Week220;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5631 {

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty()) {

            }
            if (!deque.isEmpty()) {
                dp[i] = dp[deque.getFirst()] + nums[i];
            } else {
                dp[i] = Integer.MIN_VALUE;
            }
            deque.addFirst(i);
        }

        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
            while (!deque.isEmpty() && dp[deque.getFirst()] < dp[i]) {
                deque.poll();
            }
            deque.addFirst(i);
            while (!deque.isEmpty() && i - k > deque.getLast()) {
                deque.removeLast();
            }
//            deque.forEach(val -> System.out.print(val + " "));
//            System.out.println(deque);
            for (Integer integer : deque) {
                System.out.print(integer + " ");
            }
            System.out.println();

            dp[i] = Math.max(dp[deque.getFirst()] + nums[i], dp[i]);

//            for (int j = i-1; j >= i - k && j >= 0; j--) {
//                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
//
//            }
        }
        return dp[len - 1];
    }

}

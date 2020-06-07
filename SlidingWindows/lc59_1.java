import java.util.*;

/**
 * 面试题59 - I. 滑动窗口的最大值
 */
public class lc59_1 {

   // 滑动窗口 双端队列  单调队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len + 1 - k];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 从队列后部入队,队列
            //单调递减队列，队列首部为最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.getFirst() == i - k ) deque.removeFirst();
            if (i > k) res[idx++] = nums[deque.getFirst()];
        }
        return res;
    }

    // 暴力法 堆优化
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len == 0) return new int[]{};
        int[] res = new int[len + 1 - k];
        int idx = 0;
        // 默认最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < len; i++) {
            pq.add(nums[i]);
            if (pq.size() == k) {
                res[idx++] = pq.peek();
                // 去除最左端
//                System.out.println(nums[i - k + 1]);
                pq.remove(nums[i - k + 1]);
            }
        }
        return res;
    }

    // 暴力法
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len + 1 - k];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (i + 3 > len) break;
            for (int j = i; j < i + 3; j++) {
                res[idx] = Math.max(nums[j], res[idx]);
            }
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(nums.length);
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow1(nums, 3)));
    }
}

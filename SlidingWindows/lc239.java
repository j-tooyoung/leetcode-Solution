import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: lc239
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/13 10:37
 * @author: tooyoung
 */

public class lc239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            while (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            if (i >= k-1) {
                res[idx++] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

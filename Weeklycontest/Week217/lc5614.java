package Week217;

import week95.ListNode;

import java.util.Stack;

/**
 * @Classname lc5772
 * @Description
 * @Date 2020/11/22 18:11
 * @Created by j-tooyoung
 */
public class lc5614 {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[k];
        for (int num : nums) {
            while (!st.isEmpty()  && st.peek() > num) {
                st.pop();
            }
            st.push(num);
        }
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && st.size() + len - i > k && st.peek() > nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
        }
        st.stream().forEach(val -> System.out.print(val + " "));
        System.out.println();
        int size = st.size();
        int idx = size - 1;
        while (!st.isEmpty()) {
            if (size <= k ) {
                res[idx--] = st.peek();
            }
            st.pop();
            size--;
        }
        return res;
    }
}

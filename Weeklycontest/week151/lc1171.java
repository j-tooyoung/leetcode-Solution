package week151;

import week95.ListNode;

import java.util.*;

/**
 * @Classname lc1171
 * @Description
 * @Date 2021/1/20 20:26
 * @Created by j-tooyoung
 */
public class lc1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        ListNode dummpy = new ListNode(-1);

        set.add(0);
        while (head != null) {
            int tar = st.isEmpty() ? head.val : st.peek() + head.val;
            if (set.contains(tar)) {
                while (!st.isEmpty() && st.peek() != tar) {
                    set.remove(st.peek());
                    st.pop();
                }
            } else {
                set.add(tar);
                st.push(tar);
            }
            head = head.next;
        }
        List<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            int a = st.pop();
            // System.out.println(a);
            int b = st.isEmpty() ? 0 : st.peek();
            list.add(a - b);
        }
        head = dummpy;
        for (int i = list.size() - 1; i >= 0; i--) {
            head.next = new ListNode(list.get(i));
            head = head.next;
        }
        return dummpy.next;
    }
}

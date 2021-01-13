package Week130;

import week95.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname lc1019
 * @Description
 * @Date 2021/1/13 10:49
 * @Created by j-tooyoung
 */
public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        int len = 0;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            len++;
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            while (j < len && list.get(j) <= list.get(i)) {
                j++;
            }
            res[i] = (j < len) ? list.get(j) : 0;
        }
        // error
//        Stack<Integer> st = new Stack<>();
//        st.push(list.get(0));
//        for (int i = 1; i < len; i++) {
//            if (list.get(i) > st.peek()) {
//                st.pop();
//                st.push(list.get(i));
//                res[i - 1] = list.get(i);
//            } else {
//
//            }
//        }
        // error
//        res[len - 1] = 0;
//        int maxVal = list.get(len - 1);
//        for (int i = len - 2; i >= 0; i--) {
//            if (list.get(i) > maxVal) {
//                res[i] = 0;
//                maxVal = list.get(i);
//            } else {
//                res[i] = maxVal;
//            }
//        }
        return res;
    }
}

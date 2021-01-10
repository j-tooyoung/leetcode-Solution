package week223;

import week95.ListNode;

import java.util.*;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5652 {
    // todo improve
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int k1 = list.get(k - 1);
        int k2 = list.get(list.size() - k );

        list.set(k - 1, k2);
        list.set(list.size() - k, k1);
        cur = head;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head.next;
    }


}

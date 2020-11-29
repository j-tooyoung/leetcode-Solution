package Dweek40;

import week95.ListNode;

/**
 * @Classname lc5665
 * @Description
 * @Date 2020/11/15 23:43
 * @Created by j-tooyoung
 */
public class lc5558 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = list1;
        ListNode tmp = new ListNode(-1);
        for (int j = 0; j <= b; j++) {
            if (j == a -1) {
                tmp = list1;
            }
            list1 = list1.next;
        }
        tmp.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;
        return dummpy.next;
    }
}

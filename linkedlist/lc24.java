/**
 * ClassName: lc24
 * Package: PACKAGE_NAME
 * Description:
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @date: 2020/4/8 23:05
 * @author: tooyoung
 */

public class lc24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode prev = dummpy;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            if(tmp == null) break;      //只剩一个元素不交换

            // 交换节点
            cur.next = tmp.next;
            prev.next = tmp;
            tmp.next = cur;

            prev = cur;
            cur = cur.next;
        }
        return dummpy.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

    public static void main(String[] args) {

    }
}

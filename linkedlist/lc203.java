/**
 * ClassName: lc203
 * Package: PACKAGE_NAME
 * Description:
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @date: 2020/4/8 23:06
 * @author: tooyoung
 */

public class lc203 {

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    /**
     * 迭代
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = dummpy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummpy.next;
    }

    public static void main(String[] args) {

    }
}

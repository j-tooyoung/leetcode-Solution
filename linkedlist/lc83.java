/**
 * ClassName: lc83
 * Package: PACKAGE_NAME
 * Description:
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @date: 2020/4/8 23:05
 * @author: tooyoung
 */

public class lc83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) return head;
        if (head.val == head.next.val) return deleteDuplicates(head.next);
        else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public static void main(String[] args) {

    }
}

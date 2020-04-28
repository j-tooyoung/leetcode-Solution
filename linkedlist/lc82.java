/**
 * ClassName: lc82
 * Package: PACKAGE_NAME
 * Description:
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
 *
 * @date: 2020/4/8 23:05
 * @author: tooyoung
 */

public class lc82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = dummpy;
        while (cur.next != null) {
            ListNode tmp = null;
            if (cur.next.next != null) {
                tmp = cur.next.next;
            }else{
                break;
            }
            if (tmp.val == cur.next.val) {
                while (tmp != null && tmp.val == cur.next.val) {
                    tmp = tmp.next;
                }
                cur.next = tmp;
            } else {
                cur = cur.next;
            }
        }
        return dummpy.next;
    }

    public static void main(String[] args) {

    }
}

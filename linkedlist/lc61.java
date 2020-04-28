/**
 * ClassName: lc61
 * Package: PACKAGE_NAME
 * Description:
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * @date: 2020/4/8 23:05
 * @author: tooyoung
 */

public class lc61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int cnt = 1;
        ListNode end = head;
        while (end.next != null) {
            cnt++;
            end = end.next;
        }
        k = k % cnt;
        if (k == 0) return head;
        k = cnt - k - 1;        //走的步数
        // 保存反转后半部分链表
        ListNode ne = head;
        while (k-- > 0) {
            ne = ne.next;
        }
        //断开连接部分，将尾端连接首段，
        ListNode res = ne.next;
        ne.next = null;
        end.next = head;

        return res;
    }

    public static void main(String[] args) {

    }
}

import java.util.Random;

/**
 * ClassName: lc206
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/14 17:44
 * @author: tooyoung
 */

public class lc206 {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        ListNode res = reverseList(head.next);
        tmp.next = head;
        head.next = null;
        return res;
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        // 将链表划分为反转和未返转部分，因此须保存当前节点的前后节点
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next= null;
        System.out.print("反转前");
        ListNode.printListNode(head);
        lc206 lc206 = new lc206();
        ListNode res = lc206.reverseList2(head);
        System.out.print("反转后");
        ListNode.printListNode(res);
    }
}

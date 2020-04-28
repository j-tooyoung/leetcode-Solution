import java.util.Stack;

/**
 * ClassName: lc92
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 反转链表ii
 *  相关题型
 *  lc206 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @date: 2020/4/8 23:06
 * @author: tooyoung
 */

public class lc92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int num = n - m + 1 ; //反转节点数
        int k = m - 1;
        //哨兵节点
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode first = dummpy;
        //first节点走到反转前一节点
        while (k-- > 0) {
            first = first.next;
        }
        //将要反转的节点存入栈中，并遍历到反转节点部分的下一节点，最后拼接
        ListNode start = first.next;
        k = 1;
        Stack<ListNode> st = new Stack<>();
        while (k++ <= num) {
            st.push(start);
            start = start.next;
        }
        while (!st.empty()) {
            first.next = st.pop();
            first = first.next;
        }
        first.next = start;
        return dummpy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next= null;
        System.out.print("反转前");
        ListNode.printListNode(head);
        lc92 lc92 = new lc92();
        ListNode res = lc92.reverseBetween(head,1,3);
        System.out.print("反转后");
        ListNode.printListNode(res);
    }
}

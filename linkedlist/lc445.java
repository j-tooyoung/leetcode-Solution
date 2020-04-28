import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName: lc445
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 两数相加
 *
 * @date: 2020/4/14 11:43
 * @author: tooyoung
 */

public class lc445 {

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//        }
//
//        static void printListNode(ListNode l) {
//            if (l == null) {
//                return;
//            }
//            System.out.print("(");
//            while (l.next != null) {
//                System.out.print(l.val + " -> ");
//                l = l.next;
//            }
//            System.out.println(l.val + ")");
//        }
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l1;
        if(l2 == null) return l1;
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> st = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                b.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode dummpy = new ListNode(-1);
        ListNode res = dummpy;
        int x = 0, y = 0;
        int sum = 0;
        while (!a.isEmpty() || !b.isEmpty()) {
            if (!a.isEmpty()) x = a.pop();
            else x = 0;
            if (!b.isEmpty()) y = b.pop();
            else y = 0;
            sum += x + y;
            st.push(sum % 10);
            sum /= 10;
        }
        if(sum > 0) st.push(sum);       //有进位的情况
        while (!st.isEmpty()) {
            res.next = new ListNode(st.pop());
            res = res.next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        lc445 lc445 = new lc445();
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = null;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;
        ListNode res = lc445.addTwoNumbers(l1, l2);
        ListNode.printListNode(res);

    }

}

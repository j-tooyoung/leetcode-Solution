/**
 * 面试题22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class getKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 链表只有1个元素时
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode first = dummpy;
        ListNode second = dummpy;
        while (first != null) {
            first = first.next;
            k--;
            if (k == 0) break;
        }
        if (first == null) return null;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}

/**
 * 1290. 二进制链表转整数
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class lc1290 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res += 2 * head.val;
            head = head.next;
            System.out.println(res);
        }

        return res;
    }

}

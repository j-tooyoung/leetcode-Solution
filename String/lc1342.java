
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class lc1342 {

    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            cnt++;
        }

        return cnt;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public boolean isUnique(String astr) {
        int[] cnt = new int[257];
        int len = astr.length();
        for (int i = 0; i < len; i++) {
            if (cnt[astr.charAt(i)] != 0) {
                return false;
            } else {
                cnt[astr.charAt(i)]++;
            }
        }
        return true;
    }

    class CQueue {
        Stack<Integer> s1 ;
        Stack<Integer> s2 ;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                return -1;
            }

            return 1;
        }
    }



}

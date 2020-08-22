import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                res.add(i);
            }
        }
        return res;
    }

    boolean isValid(int val) {
        String s =  String.valueOf(val);
        for (int i = 0; i < s.length(); i++) {
            int tmp = Integer.valueOf(s.charAt(i)-'0');     //
            if (tmp == 0) return false;
            if (val % tmp != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc728 lc728 = new lc728();
        List<Integer> list = lc728.selfDividingNumbers(1, 22);
        System.out.println(list.toString());

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        if (head == null ) return new int[]{};
        while (head != null) {
            st.push(head.val);
            head = head.next;
            idx++;
        }
        int[] res = new int[idx];

        for (int i = 0; i < idx; i++) {
            res[i] = st.pop();
        }
        return res;
    }
}

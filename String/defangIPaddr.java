/**
 * 1108. IP 地址无效化
 */
public class defangIPaddr {
    public String defangIPaddr(String address) {
//        return address.replace('.', '[.]');   错误
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append('[').append('.').append(']');
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
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

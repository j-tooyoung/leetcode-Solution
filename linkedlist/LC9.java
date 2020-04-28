



public class LC9 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode first = dummpy;
        ListNode second = dummpy;
        int k = 0;
        while (k < n) {
            first = first.next;
            k++;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        // System.out.print(second.val +" ," + second.next.val);
        second.next = second.next.next;
        // System.out.print(second.val +" ," + second.next.val);
        return dummpy.next;
    }



    public static void main(String[] args) {

        LC9 lc9 = new LC9();

    }
}

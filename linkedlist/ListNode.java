/**
 * ClassName: ListNode
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/14 17:45
 * @author: tooyoung
 */
//
//public class ListNode {
//
//    private IntNode first;
//    private IntNode sentinel;       //哨兵节点
//    int size;
//
//    public class IntNode {
//
//        public int item;
//        public IntNode next;
//
//        public IntNode(int i, IntNode n) {
//            this.item = i;
//            this.next = n;
//        }
//    }
//
//
//    public ListNode(int x) {
//        first = new IntNode(x, null);
//    }
//
//    public ListNode() {
//        first = null;
//        size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    /**
//     * 打印链表
//     */
//     void printListNode() {
//        if (this == null) {
//            System.out.println( " ");
//            return;
//        }
//        System.out.print("(");
//        while (first != null) {
//            System.out.print(first.item + " -> ");
//            first = first.next;
//        }
//        System.out.println(first.item + ")");
//    }
//
//    /**
//     * 在链表后添加
//     * @param x
//     */
//    public void add(int x) {
//        IntNode p = sentinel;
//        while (p.next != null) {
//            p = p.next;
//        }
//        p.next = new IntNode(x, null);
//    }
//
//    public ListNode next() {
//        return null;
//    }
//}
//
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    private static ListNode createLinkedList(String arr) {
        // arr [1,2,3,4,5]
//        System.out.println(arr.substring(1, arr.length() - 1));
        String[] ss = arr.replaceAll("\\[","").replaceAll("\\]","").split(",");
        int[] res = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            res[i] = Integer.parseInt(ss[i]);
        }
        return createLinkedList(res);
    }

    private static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {//过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
     static void printListNode(ListNode l) {
        if (l == null) {
            System.out.println( " ");
            return;
        }
        System.out.print("(");
        while (l.next != null) {
//            System.out.print(l.val + " -> ");
            System.out.printf("%d -> ", l.val);
            l = l.next;
        }
        System.out.println(l.val + ")");
    }

    public static void main(String[] args) {
        String s = "[1,2,3,4,5]";
        ListNode head = createLinkedList(s);
        printListNode(head);
     }
}

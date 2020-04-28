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
            System.out.print(l.val + " -> ");
            l = l.next;
        }
        System.out.println(l.val + ")");
    }
}

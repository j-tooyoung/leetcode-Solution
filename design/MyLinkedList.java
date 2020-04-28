/**
 * ClassName: MyLinkedList
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/design-linked-list/
 * 707. 设计链表
 *
 * @date: 2020/4/13 10:20
 * @author: tooyoung
 */
//
//public class ListNode{
//    int val;
//    ListNode next;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}

class MyLinkedList {

    ListNode head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
//        ListNode node = new ListNode(val);
//        node.next = head.next;
//        head.next = node;
//        size += 1;
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
//        ListNode tmp = head;
//        while (tmp.next != null) {
//            tmp = tmp.next;
//        }
//        tmp.next = new ListNode(val);
//        size += 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) index = 0;

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size += 1;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode tmp = cur.next;
        tmp = null;
        cur.next = cur.next.next;
        size -= 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
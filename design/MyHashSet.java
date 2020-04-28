/**
 * ClassName: MyHashSet
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/design-hashset/
 * 705. 设计哈希集合
 * @date: 2020/4/13 10:19
 * @author: tooyoung
 */

public class MyHashSet {

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node[] nodes;
    private final static int N = 100000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new Node[N];
    }

    public void add(int key) {
        int hash = hash(key);
        if (contains(key)) {
            return;
        }else  {
            Node node = new Node(key);
            node.next = nodes[hash].next;
            nodes[hash].next = node;
        }
    }

    private int hash(int key) {
        return key % N;
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        } else {
            int hash = hash(key);
            Node head = nodes[hash];
            while (head.next != null && head.next.val != key) {
                head = head.next;
            }
            Node delNode = head.next;
            head.next = delNode.next;
            delNode = null;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        Node head = nodes[hash];
        while (head.next != null) {
            if (head.next.val == key) {
                return true;
            } else {
                head = head.next;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/**
 * ClassName: MyHashMap
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/design-hashmap/
 * 706. 设计哈希映射
 *
 * @date: 2020/4/13 10:20
 * @author: tooyoung
 */
class MyHashMap {
    private final int N = 10000;//静态数组长度10000
    private Node[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new Node[N];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        if (data[hash] == null) {//该hash地址没有链表节点
            data[hash] = new Node(-1, -1);//先存虚拟头
            data[hash].next = new Node(key, value);//再存实际头节点
        } else {
            Node prev = data[hash];//从虚拟头开始遍历
            while (prev.next != null) {
                if (prev.next.key == key) {
                    prev.next.value = value;//有键，更新值
                    return;
                }
                prev = prev.next;
            }
            prev.next = new Node(key, value);//没有键，添加节点
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = hash(key);
        if (data[hash] != null) {
            Node cur = data[hash].next;//从实际头节点开始寻找
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;//找到
                }
                cur = cur.next;
            }
        }
        return -1;//没有找到
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        if (data[hash] != null) {
            Node prev = data[hash];
            while (prev.next != null) {
                //删除节点
                if (prev.next.key == key) {
                    Node delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                    return;
                }
                prev = prev.next;
            }
        }
    }

    //哈希函数
    private int hash(int key) {
        return key % N;
    }

    //链表节点
    private class Node {
        int key;//key唯一
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

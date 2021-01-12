import java.util.HashMap;
import java.util.Iterator;

/**
 * @Classname LRU
 * @Description
 * 访问某个节点时，将其从原来的位置删除，并重新插入到链表头部。这样就能保证链表尾部存储的就是最近最久未使用的节点，当节点数量大于缓存最大空间时就淘汰链表尾部的节点。\
 * 为了使删除操作时间复杂度为 O(1)，就不能采用遍历的方式找到某个节点。HashMap 存储着 Key 到节点的映射，通过 Key 就能以 O(1) 的时间得到节点，然后再以 O(1) 的时间将其从双向队列中删除。
 * @Date 2021/1/12 21:41
 * @Created by j-tooyoung
 */
public class LRU<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node{
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<K, Node>(maxSize * 4 / 3);
        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        // 删除
        unlink(node);
//        添加到队列头部
        appendHead(node);
        return node.v;
    }

    private void unlink(Node node) {
        Node prev = node.pre;
        Node ne = node.next;
        prev.next = ne;
        ne.pre = prev;

        node.pre = null;
        node.next = null;
    }

    private void appendHead(Node node) {
//        node.next = head;
//        head.pre = node;
//        head = node;
        Node next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }


    private Node removeTail() {
        Node node = tail.pre;
        Node pre = node.pre;
        tail.pre = node.pre;
        pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);
        // 删除队尾的
        if (map.size() > maxSize) {
            Node toMove = removeTail();
            map.remove(toMove.k);
        }

    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }
}

/**
 * 二叉堆 优先级队列
 * 最大堆
 */
public class MaxPQ <Key extends Comparable<Key>>{

    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int size = 0;

    public MaxPQ(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key max() {
        return pq[1];
    }

    public int size() {
        return size;
    }

    public void insert(Key e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    public Key delMax() {
        if (size < 0) return null;
        Key max = pq[1];
        exch(1, size);
        pq[size] = null;
        size--;
        swim(1);
        return max;
    }

    public void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }


    public void sink(int k) {
        while (left(k) <= size) {
            int older = left(k);
            if (right(k) <= size && less(older, right(k))) {
                older = right(k);
            }
            if (less(older,k)) break;
            exch(older, k);
            k = older;
        }
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 父节点的索引
    int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }
}

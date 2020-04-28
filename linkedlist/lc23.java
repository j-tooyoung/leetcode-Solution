import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: lc23
 * Package: PACKAGE_NAME
 * Description:
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @date: 2020/4/8 23:04
 * @author: tooyoung
 */

public class lc23 {

    /**
     * 暴力遍历排序后，重构链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length < 2)
            return lists[0];
        ListNode dummpy = new ListNode(-1);
        ListNode res = dummpy;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            res.next = new ListNode(num);
            res = res.next;
        }
        return dummpy.next;
    }

    /**
     * 分治
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length < 2)
            return lists[0];
        ListNode dummpy = new ListNode(-1);
        ListNode res = dummpy;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            res.next = new ListNode(num);
            res = res.next;
        }
        return dummpy.next;
    }

    /**
     * 优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length < 2)
            return lists[0];
        ListNode dummpy = new ListNode(-1);
        ListNode res = dummpy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) pq.add(node.next);
            res.next = node;
            res = res.next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        lc23 lc23 = new lc23();
//        lc23.mergeKLists()
    }
}

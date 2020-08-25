import java.util.*;

/**
 * 面试题 17.09. 第 k 个数
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 *
 */
public class lc17_09 {

    // dp
    public int getKthMagicNumber(int k) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int cnt3 = 0;
        int cnt5 = 0;
        int cnt7 = 0;
        
        return 0;
    }

    // 有待解决 错误
    public int getKthMagicNumber1(int k) {
        if (k < 1) return 1;
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.add(1);
        Set<Integer> set = new HashSet<>();
        // 默认小顶堆
        //大顶堆：参数2-参数1；小顶堆：参数1-参数2
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                pq.add(val);
                if (pq.size() == k) {
                    System.out.println(pq.size());
                    return pq.peek();
                }
                int val3 = 3 * val;
                int val5 = 5 * val;
                int val7 = 7 * val;

                if (!set.contains(val3)) {
                    q.add(val3);
                    pq.add(val3);
                    set.add(val3);
                }
                if (!set.contains(val5)) {
                    q.add(val5);
                    pq.add(val5);
                    set.add(val5);
                }
                if (!set.contains(val7)) {
                    q.add(val7);
                    pq.add(val7);
                    set.add(val7);
                }
            }
        }
        return 0;
    }
}

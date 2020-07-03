import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: lc378
 * Package: PACKAGE_NAME
 * Description:
 * 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @date: 2020/4/8 23:09
 * @author: tooyoung
 */

public class lc378 {

    public int kthSmallest(int[][] matrix, int k) {
        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = matrix.length;
        for (int[] nums : matrix) {
            for (int val : nums) {
                pq.add(val);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {

    }
}

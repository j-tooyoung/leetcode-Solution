import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname lc973
 * @Description TODO
 * @Date 2020/8/25 20:53
 * @Created by xp123
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class lc973 {

    // 暴力排序
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = o1[1] * o1[1] + o1[0] * o1[0];
                int dist2 = o2[1] * o2[1] + o2[0] * o2[0];
                return dist1 - dist2;
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];  小顶堆
                return o2[1] - o1[1]; // 大顶堆
            }
        });
        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            //加上这个时间复杂度更大 ？ why 小顶堆
//             if (pq.size() > K) {
//                 pq.remove(pq.size() - 1);
//             }
            if (pq.size() < K) {
                pq.add(new int[]{i, dist});
            } else if (dist < pq.peek()[1]) {
                pq.poll();
                pq.add(new int[]{i, dist});
            }

        }
//    for (int[] arr : pq) {
//             System.out.println(points[arr[0]][0] + " " + points[arr[0]][1] + " " + arr[1]);
//         }
        int[][] res = new int[K][2];
        int idx = 0;
        while (!pq.isEmpty() && idx < K) {
            int[] arr = pq.poll();
            res[idx][0] = points[arr[0]][0];
            res[idx][1] = points[arr[0]][1];
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

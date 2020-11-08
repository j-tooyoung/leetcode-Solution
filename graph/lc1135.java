import java.util.*;

/**
 * LeetCode 1135. 最低成本联通所有城市（最小生成树+排序+并查集）
 */
public class lc1135 {

    // https://www.cnblogs.com/xym4869/p/12874684.html
    /**
     *
     * Prim 算法是依据顶点来生成的，它的每一步都会为一颗生长中的树添加一条边，一开始这棵树只有一个顶点，然后会添加 N - 1 条边，
     * 每次都是将下一条连接树中的顶点与不在树中的顶点且权重最小的边加入到树中。
     * 算法流程：
     *
     * 根据 connections 记录每个顶点到其他顶点的权重；
     * 设计一个flag，判断是否被读取过；；
     * 每次读取堆顶元素，如果曾经被读取过就不再读取，否则把其所有边加入堆；
     * @param N
     * @param connections
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
        if (N <= 1 || connections.length < N - 1) {
            return -1;
        }
        // 顶点和边
        Map<Integer, List<int[]>> map = new HashMap<>();        // 存储顶点和边，可以用List<List
        for (int[] connection : connections) {
//            List<int[]> arr = (map.containsKey(connection[0])) ? map.get(connection[0]) : new ArrayList<>();
            List<int[]> arr = map.getOrDefault(connection[0], new ArrayList<>());
            int[] c = new int[]{connection[0], connection[2]};
            arr.add(c);
            map.put(connection[0], arr);
            arr = map.getOrDefault(connection[1], new ArrayList<>());
            c = new int[]{connection[1], connection[1]};
            arr.add(c);
            map.put(connection[1], arr);
        }
        boolean[] flag = new boolean[N];
        Arrays.fill(flag, false);
        int start = connections[0][0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(map.get(start));
        int count = 1;
        flag[start - 1] = true;
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (!flag[poll[0] - 1]) {
                flag[poll[0] - 1] = true;
                priorityQueue.addAll(map.get(poll[0]));
                count++;
                res += poll[1];
            }
            if (count == N - 1) {
                return res;
            }
        }
        return -1;
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * bipartition, graph coloring
 * 785. 判断二分图
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 *
 */
public class lc785 {

    private static final int uncolored = 0;
    private static final int red = 1;
    private static final int green = 2;
    private int[] color;


    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        boolean[] vis = new boolean[len];
        color = new int[len];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (color[i] == uncolored) {
                q.add(i);
                color[i] = red;


                while (!q.isEmpty()) {
                    int node = q.poll();
                    int c = color[node] == red ? green : red;

                    for (int negihbor : graph[node]) {
                        if (color[negihbor] == uncolored) {
                            color[negihbor] = c;
                            q.add(negihbor);
                        } else if (color[negihbor] != c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
}

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * DFS, connected components
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 */
public class lc841 {

    // bfs
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            num++;
            for (int val : rooms.get(tmp)) {
                if (!vis[val]) {
                    vis[val] = true;
                    q.add(val);
                }
            }
        }
        return num == n;
    }

}

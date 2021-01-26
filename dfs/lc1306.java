import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname lc1306
 * @Description
 * @Date 2021/1/25 18:39
 * @Created by j-tooyoung
 */
public class lc1306 {
    // dfs
    public boolean canReach1(int[] arr, int start) {

        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int start, boolean[] vis) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        if (vis[start]) {
            return false;
        }
        vis[start] = true;
        return dfs(arr, start + arr[start], vis) || dfs(arr, start - arr[start],vis);
    }

    // bfs
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            int num = q.poll();

            if (num < 0 || num >= len || set.contains(num)) {
                continue;
            }
            if (arr[num] == 0) {
                return true;
            }
            set.add(num);
            q.add(num + arr[num]);
            q.add(num - arr[num]);
        }
        return false;
    }

}

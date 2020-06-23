import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: lc200
 * Package: PACKAGE_NAME
 * Description:
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 *
 * @date: 2020/4/8 22:47
 * @author: tooyoung
 */

public class lc200 {


    // bfs
    public static int numIslands(char[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        if (grid== null || grid.length == 0 || grid[0].length == 0) return res;

        int row = grid.length, col = grid[0].length;
        boolean[] vis = new boolean[row * col];
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int direction = 4;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int tmp = i * col + j;
                    if (!vis[tmp]) {
                        System.out.println(i + "," + j);
                        q.add(tmp);
                        vis[tmp] = true;
                        res++;
                    }
                    while (!q.isEmpty()) {
                        int t2 = q.poll();
                        for (int k = 0; k < direction; k++) {
                            int x = t2 / col + dx[k];
                            int y = t2 % col + dy[k];
                            // 不符合条件, 不加入
                            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') continue;
                            int t3 = x * col + y;
                            if (!vis[t3]) {
                                System.out.println(x + "," + y);
                                q.add(t3);
                                vis[t3] = true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // dfs
    public static int numIslands1(char[][] grid) {
        int res = 0;
        if (grid== null || grid.length == 0 || grid[0].length == 0) return res;

        int row = grid.length, col = grid[0].length;
        boolean[] vis = new boolean[row * col];

        int direction = 4;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = i * col + j;
                if (!vis[tmp] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, boolean[] vis, int i, int j) {
        int row = grid.length, col = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || vis[i * col + j] || grid[i][j] == '0') {
            return;
        }
        vis[i * col + j] = true;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid, vis, x, y);
        }
//        dfs(grid, vis, i + 1, j);
//        dfs(grid, vis, i - 1, j);
//        dfs(grid, vis, i , j + 1);
//        dfs(grid, vis, i, j - 1);
    }


    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid1 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '0', '1'}};
//        System.out.println(numIslands(grid));
        System.out.println(numIslands1(grid));
//        System.out.println(numIslands(grid1));
        System.out.println(numIslands1(grid1));

//        String s = "";

    }
}

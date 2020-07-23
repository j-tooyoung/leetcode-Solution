import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: lc64
 * Package: PACKAGE_NAME
 * Description:
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @date: 2020/4/8 22:56
 * @author: tooyoung
 */

public class lc64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

            }
        }
        return dp[m - 1][n - 1];
    }


    public static int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        // for (int i = 1; i < m; i++) {
        //     dp[i][0] = dp[i - 1][0] + grid[i][0];
        // }
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];

    }


    //带记忆的dfs
    public static int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
//        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = grid[0][0];
        return dfs(m - 1, n - 1, grid, dp);
    }

    private static int dfs(int row, int col, int[][] grid, int[][] dp) {
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != Integer.MIN_VALUE) return dp[row][col];
        dp[row][col] = Math.min(dfs(row, col - 1, grid, dp), dfs(row - 1, col, grid, dp)) + grid[row][col];
        return dp[row][col];
    }

    // bfs
    int ans = Integer.MAX_VALUE;

    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int rowLen = grid.length - 1;
        int colLen = grid[rowLen].length - 1;

        Pair s = new Pair(0, 0, grid[0][0]);
        Pair e = new Pair(rowLen, colLen, grid[rowLen][colLen]);

        bfs(grid, s, e);

        return ans;
    }

    private void bfs(int[][] grid, Pair s, Pair e) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            Pair c = queue.poll();

            if (c.equals(e)) {
                if (c.sum < ans) {
                    ans = c.sum;
                }
            }

            int dirX[] = {0, 1};
            int dirY[] = {1, 0};

            for (int i = 0; i < dirY.length; i++) {
                int nextX = c.x + dirX[i];
                int nextY = c.y + dirY[i];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length) {
                    int sum = c.sum + grid[nextX][nextY];
                    if (sum > ans) {
                        continue;
                    }
                    Pair p = new Pair(nextX, nextY, sum);
                    queue.add(p);
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        int sum;

        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        public Pair(int x, int y) {
            this(x, y, 0);
        }

        @Override
        public String toString() {
            return "Pair [x=" + x + ", y=" + y + ", sum=" + sum + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    public static void main(String[] args) {
        IntArr_Two_Factory intArr_two_factory = new IntArr_Two_Factory();
        String s = "[[1,3,1],[1,5,1],[4,2,1]]";
        String s1 = "[[1,2],[1,1]]";
        String s2 = "";

        int[][] grid = intArr_two_factory.produce(s1);
        int[][] grid1 = intArr_two_factory.produce(s1);
        System.out.println(minPathSum1(grid));
        System.out.println(minPathSum1(grid1));
        System.out.println(minPathSum2(grid));
        System.out.println(minPathSum2(grid1));
    }

}

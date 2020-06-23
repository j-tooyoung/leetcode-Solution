/**
 * 827. 最大人工岛
 * https://leetcode-cn.com/problems/making-a-large-island/
 */
public class lc827 {

    static int res = 0;

    public static int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;

        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1)
                + dfs(grid, i + 1, j + 1)
                + dfs(grid, i - 1, j - 1)
                + dfs(grid, i + 1, j - 1)
                + dfs(grid, i - 1, j + 1);
    }

    public static void main(String[] args) {

    }
}

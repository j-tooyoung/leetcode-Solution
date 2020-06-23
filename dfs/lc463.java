/**
 * 463. 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 */
public class lc463 {


    int res = 0;

    public int islandPerimeter(int[][] grid) {
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

    //我们可以将岛屿的周长中的边分为两类，如下图所示。黄色的边是与网格边界相邻的周长，而蓝色的边是与海洋格子相邻的周长。
//    当我们的 dfs 函数因为「坐标 (r, c) 超出网格范围」返回的时候，实际上就经过了一条黄色的边；而当函数因为「当前格子是海洋格子」返回的时候，实际上就经过了一条蓝色的边。这样，我们就把岛屿的周长跟 DFS 遍历联系起来了，我们的题解代码也呼之欲出：
    private static int dfs(int[][] grid, int i, int j) {

        int row = grid.length, col = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }

        grid[i][j] = 2;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1);

    }

    public static void main(String[] args) {
        String s = "[[0,1,0,0], [1,1,1,0], [0,1,0,0],[1,1,0,0]]";
        String tmp = StringToArratyutil.toArrayString(s);

    }
}

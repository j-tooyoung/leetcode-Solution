/**
 * 1254. 统计封闭岛屿的数目
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 */
public class lc1254 {

    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int row, col;
    public int closedIsland(int[][] grid) {
        int res = 0;
        row = grid.length; col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    res = dfs(grid, i, j) ? res : res + 1;
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        // 如果i，j在边缘，则不为封闭岛屿
        if (i < 0 || j < 0 || i >= row  || j >= col  ) {
            return true;
        }
        if (grid[i][j] != 0) {
            return false;
        }

        // 设置（i,j）访问了
        grid[i][j] = 2;

        //短路性质,使得如果有一个为true,后续的遍历终止不再进行
//        return dfs(grid, i + 1, j) || dfs(grid, i - 1, j) || dfs(grid, i, j + 1) || dfs(grid, i, j - 1);
        boolean flag1 = dfs(grid, i + 1, j);
        boolean flag2 = dfs(grid, i - 1, j);
        boolean flag3 = dfs(grid, i, j + 1);
        boolean flag4 = dfs(grid, i, j - 1);
        return flag1 || flag2 || flag3 || flag4;
    }


    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] grid1 = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid2 = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        int[][] grid3 = {{0, 1}};
        String s = "[[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]";
        String s1 = "[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]";
        String s2 = "[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]";
//        System.out.println(StringToArratyutil.toArrayString(s));
//        System.out.println(StringToArratyutil.toArrayString(s1));
//        System.out.println(StringToArratyutil.toArrayString(s2));

        System.out.println(new lc1254().closedIsland(grid));
//        System.out.println(new lc1254().closedIsland(grid1));
//        System.out.println(new lc1254().closedIsland(grid2));
        System.out.println(new lc1254().closedIsland(grid3));

    }

}

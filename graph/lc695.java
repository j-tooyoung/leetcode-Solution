/**
 * 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class lc695 {


    // 0陆地， 1 水， 2访问过
    static int res = 0;
    public static int maxAreaOfIsland(int[][] grid) {
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
                + dfs(grid, i, j - 1);

    }

//    private static void dfs(int[][] grid, int i, int j, int cnt) {
//        int row = grid.length, col = grid[0].length;
//
//        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
//            return ;
//        }
//
//        grid[i][j] = 2;
//        cnt++;
//        System.out.println("cnt : " + cnt);
//        System.out.println(i + "," + j);
//        dfs(grid, i + 1, j, cnt);
//        dfs(grid, i - 1, j, cnt);
//        dfs(grid, i, j + 1, cnt);
//        dfs(grid, i, j - 1, cnt);
////        return cnt;
//        res = Math.max(res, cnt);
////        System.out.println("res : " + res);
//    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        String s = "[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]";
        String s1 = "[[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]";
        System.out.println(s.replaceAll("\\[", "{").replaceAll("\\]", "}"));
        System.out.println(s1.replaceAll("\\[", "{").replaceAll("\\]", "}"));
        System.out.println(maxAreaOfIsland(grid));
    }

}

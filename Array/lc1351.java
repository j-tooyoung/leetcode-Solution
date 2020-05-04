/**
 * 1351. 统计有序矩阵中的负数
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class lc1351 {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) res++;
            }
        }
        return res;
    }

    public int countNegatives1(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) res++;
            }
        }
        return res;
    }

}

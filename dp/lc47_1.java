/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class lc47_1 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];

//        int row = grid.length, col = grid[0].length;
//        int[][] dp = new int[row][col];
//        dp[0][0] = grid[0][0];
//        for (int i = 1; i < row; i++) {
//            dp[i][0] = dp[i - 1][0] + grid[i][0];
//        }
//        for (int i = 1; i < col; i++) {
//            dp[0][i] = dp[0][i - 1] + grid[0][i];
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (i > 0 && j > 0) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
//        return dp[row - 1][col - 1];
    }

}

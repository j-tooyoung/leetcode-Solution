/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class lc221 {

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) return 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        res = Math.max(res, dp[i][j] * dp[i][j]);
                    }
                }
            }
        }
        return res;
    }

    public int maximalSquare1(char[][] matrix) {
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i - 1][j - 1] = 0;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}

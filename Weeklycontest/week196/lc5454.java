package week196;

/**
 * 5454. 统计全 1 子矩形
 * https://leetcode-cn.com/contest/weekly-contest-196/problems/count-submatrices-with-all-ones/
 *
 */
public class lc5454 {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {

                }
            }
        }
        return dp[row][col];
    }

}

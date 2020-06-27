/**
 * ClassName: lc63
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:56
 * @author: tooyoung
 */

public class lc63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 :1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }

}

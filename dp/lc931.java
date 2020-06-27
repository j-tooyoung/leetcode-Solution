import java.util.Arrays;

/**
 * 931. 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class lc931 {

    public static int minFallingPathSum(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] dp = new int[row ][col ];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                    continue;
                }
                int best = dp[i - 1][j];
                if (j > 0) {
                    best = Math.min(best, dp[i - 1][j - 1]);
                }
                if (j + 1 < row) {
                    best = Math.min(best, dp[i - 1][j + 1]);
                }
                // System.out.println(best + " ," + A[i][j]);

                dp[i][j] = best + A[i][j];
            }
        }
        // for (int i = 0; i < row; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(A));
    }

}

/**
 * ClassName: lc62
 * Package: PACKAGE_NAME
 * Description:
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @date: 2020/4/8 22:56
 * @author: tooyoung
 */

public class lc62 {

    // 法1 组合,总共步数m + n - 2
    // 横向步数 m - 1

    // dp
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1 && j >= 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 数组优化
    public static int uniquePaths3(int m, int n) {
        return 0;
    }

    // 超时
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
//        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);
        if (dp[m][n] > 0) {
            return dp[m][n];
        }
        dp[m - 1][n] = uniquePaths1(m - 1, n);
        dp[m][n - 1] = uniquePaths1(m, n - 1);
        return dp[m - 1][n] + dp[m][n - 1];
    }

    //回溯
    static int res = 0;

    public static int uniquePaths2(int m, int n) {
        dfs(0, 0, m, n);
        return res;
    }

    private static void dfs(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            res++;
            return;
        }
        if (i < m) dfs(i + 1, j, m, n);
        if (j < n) dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) {
//        System.out.println(uniquePaths(3, 2));
//        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(3, 2));
//        System.out.println(uniquePaths1(7, 3));
    }

}

package week203;

/**
 * 5498. 石子游戏 V
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/stone-game-v/
 */
public class lc5498 {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n + 1];
        // 前缀和
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }
        int[][] f = new int[n + 1][n + 1];
        // 区间长度
        for (int len = 2; len <= n; len++) {
            // 左端点
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                // 枚举中间节点
                for (int k = i; k < j; k++) {
                    // 区间和
                    int left = sum[k] - sum[i-1];
                    int right = sum[j] - sum[k];
                    if (left > right) {
                        f[i][j] = Math.max(f[i][j], right + f[k + 1][j]);
                    } else if (left < right) {
                        f[i][j] = Math.max(f[i][j], left + f[i][k]);
                    } else {
                        f[i][j] = Math.max(f[i][j], left + Math.max(f[i][k], f[k + 1][j]));
                    }
                }
            }
        }
        return f[1][n];
    }

}

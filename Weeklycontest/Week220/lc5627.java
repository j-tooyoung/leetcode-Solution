package Week220;

import java.util.Arrays;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5627 {

    // bob移除的数字就是差值
    public int stoneGameVII1(int[] stones) {
        int[] sum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        int len = stones.length;
        int[][][] dp = new int[len][len][2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                dp[i][j][0] = Math.min(Math.min(dp[i + 1][j][1], dp[i][j - 1][1]), dp[i][j][0]);
                dp[i][j][1] = Math.min(Math.min(dp[i + 1][j][0] + stones[i], dp[i][j - 1][0] + stones[j]), dp[i][j][1]);
            }
        }

        return dp[len - 1][len - 1][0];
    }

    int res = Integer.MAX_VALUE;

    public int stoneGameVII(int[] stones) {
        boolean flag = true;
        dfs(stones, 0, stones.length - 1, flag, 0);
        return res;
    }

    private int dfs(int[] stones, int lo, int hi, boolean flag, int cnt) {
        if (lo >= stones.length || hi < 0) {
            return 0;
        }
        if (lo > hi) {
            res = Math.min(res, cnt);
        }
        if (flag) {
            return Math.min(dfs(stones, lo + 1, hi, !flag, cnt), dfs(stones, lo, hi - 1, !flag, cnt));
        }else{
            return Math.min(dfs(stones, lo + 1, hi, !flag, cnt + stones[lo]), dfs(stones, lo, hi - 1, !flag, cnt + stones[hi]));
        }
    }
}

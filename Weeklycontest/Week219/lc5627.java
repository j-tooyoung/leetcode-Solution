package Week219;

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
        int[][] dp = new int[len][len];
        for (int k = 1; k < len; k++) {
            for (int i = 0; i < len; i++) {
                int j = i + k;
                if (j == len) break;
                dp[i][j] = Math.max(sum[j + 1] - sum[i+1] - dp[i + 1][j], sum[j] - sum[i] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }

    int[][] memo;

    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        this.memo = new int[len + 1][len + 1];
        for (int[] val : memo) {
            Arrays.fill(val, Integer.MIN_VALUE);
        }
//        Arrays.fill(memo, Integer.MIN_VALUE);

        int sum = Arrays.stream(stones).sum();
        return dfs(stones, 0, stones.length - 1, sum);
    }

    private int dfs(int[] stones, int lo, int hi, int sum) {

        if (lo >= stones.length || hi < 0 || lo == hi) {
            return 0;
        }
        if (memo[lo][hi] != Integer.MIN_VALUE) {
            return memo[lo][hi];
        }
        int choseLeft = sum - stones[lo] - dfs(stones, lo + 1, hi, sum - stones[lo]);
        int choseRight = sum - stones[hi] - dfs(stones, lo, hi - 1, sum - stones[hi]);
        memo[lo][hi] = Math.max(choseLeft, choseRight);
        return memo[lo][hi];
    }
}

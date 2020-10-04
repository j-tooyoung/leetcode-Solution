package fallContest2020;

import com.sun.imageio.plugins.common.I18N;

/**
 * https://leetcode-cn.com/contest/season/2020-fall/problems/UlBDOe/
 * 3. 秋叶收藏集
 */
public class c3 {

    // https://leetcode-cn.com/problems/UlBDOe/solution/dong-tai-gui-hua-java-qiu-xie-shou-cang-ji-by-crus/
    public int minimumOperations(String leaves) {

        int len = leaves.length();
        int[][] dp = new int[len][3];

        dp[0][0] = (leaves.charAt(0) == 'y') ? 1 : 0;
        //遵循叶子的数量必须大于等于状态的数量
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int isRed = (leaves.charAt(i) == 'r') ? 1 : 0;
            int isYellow = (leaves.charAt(i) == 'y') ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed;
            // 红黄红状态，要有三个节点
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1]) + isYellow;
            }
        }
        return dp[len - 1][2] == Integer.MAX_VALUE ? 0 : dp[len - 1][2];
    }
}

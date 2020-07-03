import java.util.Arrays;

/**
 * ClassName: lc322
 * Package: PACKAGE_NAME
 * Description:
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @date: 2020/4/8 23:00
 * @author: tooyoung
 */

public class lc322 {

    public static int coinChange(int[] coins, int amount) {
        if (coins.length < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //边界条件
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    System.out.println(dp[i]);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);

        return 0;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int[] coins1 = {2};
        System.out.println(coinChange(coins, 11));
//        System.out.println(coinChange(coins1, 3));
    }

}

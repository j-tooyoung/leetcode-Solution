/**
 * 面试题14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class cuttingRope {

    // dp有问题
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
       if (n <= 3) return n - 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[j] * (i - j), (i - j) * j), dp[i]);
            }
        }
        return dp[n];
    }

    // 贪心
    public static int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        if (n % 3== 0) return (int) Math.pow(3, n / 3);
        else if(n % 3 == 1) return (int) (Math.pow(3, n / 3 - 1) * 4);
        else return (int) (2 * Math.pow(3, n / 3));
    }

    // 暴力
    public static int cuttingRope2(int n) {
       if (n == 2) return 1;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, cuttingRope2(n - i) * i);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 10; i++) {
            System.out.println(i + "," + cuttingRope2(i));
        }
    }

}

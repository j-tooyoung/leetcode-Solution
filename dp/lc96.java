/**
 * ClassName: lc96
 * Package: PACKAGE_NAME
 * Description:
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @date: 2020/4/8 22:57
 * @author: tooyoung
 */

public class lc96 {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        int res = 0;
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
//        for (int i = 1; i < 10; i++) {
//            System.out.println(i + ", " + numTrees(i));
//        }
    }

}

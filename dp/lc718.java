/**
 * ClassName: lc718
 * Package: PACKAGE_NAME
 * Description:
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @date: 2020/4/8 23:02
 * @author: tooyoung
 */

public class lc718 {

    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1][len2];
        dp[0][0] = (A[0] != B[0]) ? 0 : 1;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {

    }
}

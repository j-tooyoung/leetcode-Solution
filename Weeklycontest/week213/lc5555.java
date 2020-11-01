package week213;

/**
 * @Classname lc5522
 * @Description 5555. 统计字典序元音字符串的数目
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/count-sorted-vowel-strings/
 * @Created by j-tooyoung
 */
public class lc5555 {

    public int countVowelStrings(int n) {
//        (动态规划) O(n)
//        设状态 f(i,j) 表示构造前 i 个字符，以元音 j 结尾的方案数。i 的有效下标从 0 开始，j 的范围是 0 到 4。
//        初始时，f(0,j)=1，其余为 0。
//        转移时，对于 f(i,j)，设 0≤k≤j，则其可以从 f(i−1,k) 转移，即 f(i,j)=f(i,j)+f(i−1,k)。
//        最终答案为 ∑4j=0f(n−1,j)。
//        时间复杂度
        int ans = 0;
        int[][] dp = new int[n ][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }
        return ans;
//        int[][] dp = new int[n + 1][5];
//        for (int i = 0; i < 5; i++) {
//            dp[0][i] = 0;
//            dp[1][i] = 1;
//        }
//        int ans = 0;
//        for (int i = 2; i <= n; i++) {
//            for (int j = 0; j < 5; j++) {
//                for (int k = 4; k >= j; k--) {
//                    dp[i][j] += dp[i - 1][k];
//                }
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            ans += dp[n][i];
//        }
//        return ans;
    }

    public static void main(String[] args) {
        System.out.println(66045 / 5);
        System.out.println((13209-1) / 2);
    }

}

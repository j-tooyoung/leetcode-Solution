package Dweek38;

/**
 * @Classname lc5547
 * @Description
 * 5542. 通过给定词典构造目标字符串的方案数
 * https://leetcode-cn.com/contest/biweekly-contest-38/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * @Date 2020/10/18 20:13
 * @Created by j-tooyoung
 */
public class lc5542 {

    // todo
    public int numWays(String[] words, String target) {
        int len = target.length();
        int wordLen = words.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wordLen; j++) {
                for (int k = 0; k < len; k++) {
                    if (target.charAt(i) == words[j].charAt(k)) {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }
                }

            }
        }
        return dp[len - 1][len - 1];
    }

}

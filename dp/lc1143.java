import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class lc1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        //错误
//        int len1 = text1.length();
//                int len2 = text2.length();
//                int[][] dp = new int[len1][len2];
//                dp[0][0] = (text1.charAt(0) != text2.charAt(0)) ? 0 : 1;
//                char[] ch1 = text1.toCharArray();
//                char[] ch2 = text2.toCharArray();
//                for (int i = 1; i < len1; i++) {
//                    for (int j = 1; j < len2; j++) {
//                        if (ch1[i] == ch2[j]) {
//                            dp[i][j] = dp[i - 1][j - 1] + 1;
//                        } else {
//                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                        }
//                    }
//                }
//                return dp[len1 - 1][len2 - 1];

        if (text1 == null || text1.length() < 1 || text2 == null || text2.length() < 1) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                }
            }
        }
        for (int[] num : dp) {
            System.out.println(Arrays.toString(num));
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
//        String text1 = "abc";
//        String text2 = "def";
//        System.out.println(longestCommonSubsequence(text1, text2));
//        String text3 = "abc";
//        String text4 = "abc";
//        System.out.println(longestCommonSubsequence(text3, text4));
        String text5 = "abcde";
        String text6 = "ace";
        System.out.println(longestCommonSubsequence(text5, text6));

    }
}

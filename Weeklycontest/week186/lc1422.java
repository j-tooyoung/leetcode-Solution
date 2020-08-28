package week186;

/**
 * 1422. 分割字符串的最大得分
 * https://leetcode-cn.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
 */
public class lc1422 {

    public int maxScore(String s) {
        int len = s.length();
        int[] cnt0 = new int[len + 1];
        int[] cnt1 = new int[len + 1];
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == '0') {
                cnt0[i] = cnt0[i - 1] + 1;
            } else {
                cnt0[i] = cnt0[i - 1];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cnt1[i] = cnt1[i + 1] + 1;
            } else {
                cnt1[i] = cnt1[i + 1];
            }
            if (i > 0) ans = Math.max(ans, cnt0[i] + cnt1[i]);
        }
        return ans;
    }
}

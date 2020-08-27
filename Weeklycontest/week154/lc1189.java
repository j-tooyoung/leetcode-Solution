package week154;

/**
 * 1189. “气球” 的最大数量
 * https://leetcode-cn.com/contest/weekly-contest-154/problems/maximum-number-of-balloons/
 */
public class lc1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        int len = text.length();
        for (int i = 0; i < len; i++) {
            cnt[text.charAt(i) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(cnt[0], ans);
        ans = Math.min(cnt['b'-'a'], ans);
        ans = Math.min(cnt['l' - 'a'] / 2, ans);
        ans = Math.min(cnt['o' - 'a'] / 2, ans);
        ans = Math.min(cnt['n' - 'a'], ans);

        return ans;
    }

}

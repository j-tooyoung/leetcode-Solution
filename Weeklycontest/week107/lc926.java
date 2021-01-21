package week107;

/**
 * 926. 将字符串翻转到单调递增
 * https://leetcode-cn.com/contest/weekly-contest-107/problems/flip-string-to-monotone-increasing/
 */
public class lc926 {

    public int minFlipsMonoIncr(String S) {
        int len = S.length();
        int[] zero = new int[S.length() + 1];
        int[] one = new int[S.length()+ 1];
        for (int i = 0; i < S.length(); i++) {
            zero[i + 1] = zero[i] + (S.charAt(i) == '0' ? 0 : 1);
            one[i + 1] = Math.min(one[i], zero[i]) + (S.charAt(i) == '0' ? 1 : 0);
        }
        return Math.min(one[len], zero[len]);
    }

    //  左边+右边修改次数，左边全为0，右边包括此位为1
    public int minFlipsMonoIncr1(String S) {
        int n = S.length();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (S.charAt(i) == '1' ? 1 : 0);
        }
        int res = 0x3f3f3f3f;
        int total = pre[n];
        for (int i = 0; i < n; i++) {
            int left = pre[i];
            int right = (n - i - (total - pre[i]));
            res = Math.min(res, left + right);
        }
        res = Math.min(res, total);
        return res;
    }
}

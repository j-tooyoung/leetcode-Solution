package Week173;

/**
 * 1332. 删除回文子序列
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */
public class lc1332 {

    private int len;

    public int removePalindromeSub(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return 2;
            }
        }
        return 1;
    }
}

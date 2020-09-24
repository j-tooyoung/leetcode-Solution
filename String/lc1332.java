/**
 * 1332. 删除回文子序列
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */
public class lc1332 {

    public int removePalindromeSub(String s) {
        if (s == null ||  s.length() == 0) return 0;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}

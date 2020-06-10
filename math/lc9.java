/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
// 解法
//   https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
public class lc9 {

    // 字符串
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int right = x % 10;
            int left = x / div;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    //
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int res = 0;
        int a = x;
        while (a > 0) {
            res = res * 10 + x % 10;
            a /= 10;
        }
        return x == res;
    }

}

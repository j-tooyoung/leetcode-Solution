import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc5
 * Package: PACKAGE_NAME
 * Description:
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @date: 2020/4/8 22:55
 * @author: tooyoung
 */

public class lc5 {

    // 动态规划
    public static String longestPalindrome(String s) {
        int len = s.length();
        int res = 0;
        int k = 0, m = 0;
        int[][] dp = new int[len][len];

        return null;
    }

    // 暴力法
    public static String longestPalindrome1(String s) {
        if(s == null || s.length() == 0) return s;
        int len = s.length();
        int res = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            // 以i为中心
            if (helper(s, i, i) >= res) {
                res = helper(s, i, i);
                start = i - res / 2;
                end = i + res / 2;
            }
            if (helper(s, i, i + 1) >= res) {
                res = helper(s, i, i + 1);
                start = i - res / 2 + 1;
                end = i + res / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int helper(String s, int m1, int m2) {
        if (m1 < 0 || m2 >= s.length()) return 0;
        while (s.charAt(m1) == s.charAt(m2)) {
            m1--;
            m2++;
            if (m1 < 0) break;
            if (m2 >= s.length()) break;
        }
        return (m2 - m1 - 1);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("babad");
            add("abcba");
            add("cbbd");
            add("");
        }};
        for (String s : list) {
            System.out.println(s +" : " + longestPalindrome1(s));
        }

    }
}

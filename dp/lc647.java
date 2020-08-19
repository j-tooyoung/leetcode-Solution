/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 */
public class lc647 {

    public static int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < len; i++) {
            res += countPalindrome(ch, i, i + 1);       //回文串长度为偶数
            res += countPalindrome(ch, i, i);           //回文串长度为奇数
//            int lo = i, hi = i;
//            while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
//                lo--;
//                hi++;
//                res++;
//            }
//            // 与第一个重复计算了
////            lo = i - 1;
////            hi = i + 1;
////            while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
////                lo--;
////                hi++;
////                res++;
////            }
//            lo = i - 1;
//            hi = i;
//            while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
//                lo--;
//                hi++;
//                res++;
//            }
        }
        return res;
    }

    private static int countPalindrome(char[] chars, int start, int end) {
        int res = 0;
        int len = chars.length;
        while (start >= 0 && end < len && chars[start++] == chars[end--]) {
            res++;
        }
        return res;
    }

        // 动态规划
    public static int countSubstrings1(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int lo = i, hi = i;
            while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
                res++;
            }

            lo = i - 1;
            hi = i;
            while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
                res++;
            }
        }
        return res;
    }

    // Manacher算法处理回文子串 马拉车算法
    public static int countSubstrings2(String s) {
        return 0;
    }

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "aaa";
        String s2 = "aa";
        String s3 = "abba";
        String s4 = "aba";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings(s1));
        System.out.println(countSubstrings(s2));
        System.out.println(countSubstrings(s3));
        System.out.println(countSubstrings(s4));
    }

}

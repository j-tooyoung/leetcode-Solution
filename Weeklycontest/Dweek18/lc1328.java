package Dweek18;

/**
 * 1328. 破坏回文串
 * https://leetcode-cn.com/contest/biweekly-contest-18/problems/break-a-palindrome/
 */
public class lc1328 {

    public static String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len <= 1) return "";
        char[] chars = palindrome.toCharArray();
        int i;
        boolean flag = false;
        for (i = 0; i < len; i++) {
            // 中间不能改
            if (chars[i] == 'a' || i == len / 2) {
                continue;
            } else {
                flag = true;
                chars[i] = 'a';
                break;
            }
        }
        // 全为a,就改最后一项
        if (!flag) chars[len - 1] = 'b';
        return  String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "aa";
        String s1 = "aaa";
        String s2 = "aba";
        System.out.println(breakPalindrome(s));
        System.out.println(breakPalindrome(s1));
        System.out.println(breakPalindrome(s2));

    }

}

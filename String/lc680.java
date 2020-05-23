import java.util.Arrays;
import java.util.List;

/**
 * 680. 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 */
public class lc680 {

    // 暴力，
    public static boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (Palindrome(ch, 0, s.length() - 1, i)) return true;
        }
        return false;
    }

    // 贪心
    public static boolean validPalindrome1(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else {
                return Palindrome(ch, i + 1, j) || Palindrome(ch, i, j - 1);
            }
        }
        return true;
    }

    static boolean Palindrome(char[] ch, int i, int j) {
//        if (i)
        while (i < j) {
            if (ch[i] != ch[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }


        static boolean  Palindrome(char[] ch, int i, int j, int idx) {
        if (i > j) return true;
        while (i < j) {
            if (i == idx) {
                i++;
                continue;
            }
            if (j == idx) {
                j--;
                continue;
            }
            if (ch[i] != ch[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","aa","aba", "abca", "abcda");
        for (String s : list) {
            System.out.println(s +": " + validPalindrome1(s));
        }
    }

}

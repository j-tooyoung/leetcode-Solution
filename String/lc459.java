/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class lc459 {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int maxlen = len / 2;
        // 重复子串长度 i最大不超过一半
        for (int i = 1; i <= maxlen; i++) {
            if (len % i == 0) {
                boolean match = true;
                // 遍历字符串，j与前一个字符串的i应相等
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * 389. 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class lc389 {

    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char ch : s.toCharArray()) {
            res ^= ch;
        }

        for (char ch : t.toCharArray()) {
            res ^= ch;
        }
        return res;
    }

}

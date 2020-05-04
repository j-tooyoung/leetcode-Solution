/**
 * 1323. 6 和 9 组成的最大数字
 * https://leetcode-cn.com/problems/maximum-69-number/
 */
public class lc1323 {
    public int maximum69Number(int num) {
        char[] s = String.valueOf(num).toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '6') {
                s[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }
}

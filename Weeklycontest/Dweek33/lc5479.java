package Dweek33;

/**
 *5479. 千位分隔数
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/thousand-separator/
 */
public class lc5479 {

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = String.valueOf(n).toCharArray();
        int cnt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
            cnt++;
            if (i > 0 && cnt % 3 == 0) {
                sb.append('.');
            }
        }
        return sb.reverse().toString();
    }

}

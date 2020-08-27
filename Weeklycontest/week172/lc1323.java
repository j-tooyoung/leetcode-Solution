package week172;

/**
 * 1323. 6 和 9 组成的最大数字
 * https://leetcode-cn.com/contest/weekly-contest-172/problems/maximum-69-number/
 */
public class lc1323 {

    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '9') {
                continue;
            } else {
                chars[i] = '9';
                break;
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }

}

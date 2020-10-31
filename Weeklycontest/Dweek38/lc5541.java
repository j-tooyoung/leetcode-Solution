package Dweek38;

/**
 * @Classname lc5546
 * @Description
 * https://leetcode-cn.com/contest/biweekly-contest-38/problems/count-substrings-that-differ-by-one-character/
 * 5541. 统计只差一个字符的子串数目
 * @Date 2020/10/18 20:13
 * @Created by j-tooyoung
 */
public class lc5541 {


    public int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i;
                for (int k = 0; k + len < t.length(); k++) {
                    if (isValid(s, i, j, t, k, k + len)) {
                        System.out.println(s.substring(i, j + 1) + " " + t.substring(k, k + len + 1));
                        res++;
                    }
                }
            }
        }
        return res;
    }

    boolean isValid(String s, int i, int j, String t, int m, int n) {
        int cnt = 0;
        for (int k = i, l = m; k <= j; k++, l++) {
            if (s.charAt(k) != t.charAt(l)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        return cnt == 1;
    }

}

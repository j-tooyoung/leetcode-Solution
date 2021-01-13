package Dweek20;

/**
 * @Classname lc1358
 * @Description
 * @Date 2021/1/13 11:11
 * @Created by j-tooyoung
 */
public class lc1358 {

    public int numberOfSubstrings(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
//            int cnt = 0;
            int cnt1 = 0;
            int cnt2 = 0;
            int cnt3 = 0;
            int j = i;
            while (j < s.length() && cnt1 + cnt2 + cnt3 != 3) {
                if (s.charAt(j) == 'a') {
                    cnt1 = 1;
                } else if (s.charAt(j) == 'b') {
                    cnt2 = 1;
                } else if (s.charAt(j) == 'c') {
                    cnt3 = 1;
                }
                j++;
            }
            if (j <= s.length() && cnt1 + cnt2 + cnt3 == 3) {
                res += len - j + 1;
            }
        }
        return res;
    }

}

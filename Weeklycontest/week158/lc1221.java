package week158;

/**
 * @Classname lc1211
 * @Description
 * @Date 2021/1/11 10:18
 * @Created by j-tooyoung
 */
public class lc1221 {

    public int balancedStringSplit(String s) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cnt++;
            } else {
                cnt--;

            }
            if (cnt == 0) {
                res++;
            }
        }
        return res;
    }
}

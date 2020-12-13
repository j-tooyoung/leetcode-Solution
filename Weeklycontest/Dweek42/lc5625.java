package Dweek42;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5625 {

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                res += (n / 2);
                n >>= 1;
            } else {
                res += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return res;
    }

}

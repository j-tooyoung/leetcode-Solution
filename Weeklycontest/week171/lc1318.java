package week171;

/**
 * @Classname lc1318
 * @Description
 * @Date 2021/1/23 14:02
 * @Created by j-tooyoung
 */
public class lc1318 {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while (a > 0 || b > 0 || c > 0) {
            int a1 = a & 1;
            int b1 = b & 1;
            int c1 = c & 1;
            if ((a1 | b1) == c1) {

            } else {
                res += Math.abs(a1 + b1 - c1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return res;
    }

}

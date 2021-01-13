package Week130;

/**
 * @Classname lc1017
 * @Description
 * @Date 2021/1/13 10:41
 * @Created by j-tooyoung
 */
public class lc1017 {

    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        String res = "";
        int n = N;
        while (n != 0) {
            if (n % 2 == 0) {
                res = "0" + res;
                n /= (-2);
            } else {
                res = "1" + res;
                n = (n - 1) / (-2);
            }
        }

        return res;
    }

}

/**
 * ClassName: lc50
 * Package: PACKAGE_NAME
 * Description:
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @date: 2020/4/8 22:51
 * @author: tooyoung
 */

public class lc50 {

    public double myPow(double x, int n) {
        double res = 1.0;
        if (n == 0) {
            return 1.0;
        } else if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        if (n == 1) {
            return x;
        }
        double a = myPow(x, n >> 1);
        if ((n & 1) == 1) {
            return a * a * x;
        } else {
            return a * a;
        }


    }

    public static void main(String[] args) {

    }
}

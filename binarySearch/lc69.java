/**
 * ClassName: lc69
 * Package: PACKAGE_NAME
 * Description:
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * @date: 2020/4/8 22:51
 * @author: tooyoung
 */

public class lc69 {

    public int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 0, hi = x / 2;
        while (lo < hi) {
            int mid = lo + hi  + 1>> 1;
//            if (x < mid * mid) {
            //超时 溢出
            if (x / mid < mid ) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;  // return hi
        //        return (int) Math.sqrt(x);
    }

    // 写成指数形式
    public int mySqrt1(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }

    public int mySqrt2(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;

    }

    public static void main(String[] args) {
        lc69 lc69 = new lc69();
        System.out.println(lc69.mySqrt(8));
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i +  "," + lc69.mySqrt(i));
//        }
    }
}

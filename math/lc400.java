/**
 * @Classname lc400
 * @Description
 * 400. 第N个数字
 * https://leetcode-cn.com/problems/nth-digit/
 * 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @Date 2020/10/5 6:44
 * @Created by j-tooyoung
 */
public class lc400 {

//    https://leetcode-cn.com/problems/nth-digit/solution/xiang-jie-zhao-gui-lu-by-z1m/
    // 1位数 9个
    // 2位数 90个
    // 3位数 900个

    public int findNthDigit(int n) {
        if (n < 10) return n;

        int base = 9;
        int cnt = 1;
        while (n - base * cnt > 0) {
            n -= base * cnt;
            cnt++;
            base *= 10;
        }
        int num = n / cnt + (int) Math.pow(10, cnt - 1) - 1;
        n %= cnt;
        String str = String.valueOf(num);
        if (n==0) return Integer.valueOf(str.charAt(cnt-1) - '0');
        return Integer.valueOf(str.charAt(n-1)-'0');
    }
}

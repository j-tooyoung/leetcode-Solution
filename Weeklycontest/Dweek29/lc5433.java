package Dweek29;

/***
 * 5433. n 的第 k 个因子
 * https://leetcode-cn.com/contest/biweekly-contest-29/problems/the-kth-factor-of-n/
 *
 */
public class lc5433 {

    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        if (k > 0) {
            return -1;
        }
        return 0;
    }
}

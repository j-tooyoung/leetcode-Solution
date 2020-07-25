package Dweek31;

/**
 *5456. 在区间范围内统计奇数数目
 * https://leetcode-cn.com/contest/biweekly-contest-31/problems/count-odd-numbers-in-an-interval-range/
 *
 */
public class lc5456 {

    public int countOdds(int low, int high) {
        int cnt = 0;
        cnt += (high % 2 == 0) ? 0 : 1;
        cnt += (low % 2 == 0) ? 0 : 1;
        if (cnt == 2) return (high - low) / 2 + 1;
        else return (high - low) / 2 + cnt;

//        for (int i = low; i <= high; i++) {
//            cnt += (i % 2 != 0) ? 1 : 0;
//        }
//        return cnt;
    }

    public static void main(String[] args) {

    }

}

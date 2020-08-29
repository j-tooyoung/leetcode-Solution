package Dweek19;

/**
 * 1342. 将数字变成 0 的操作次数
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class lc1342 {

    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                cnt++;
                num /= 2;
            } else {
                num -= 1;
                cnt++;
            }
        }
        return cnt;
    }

}

package fallContest2020;

/**
 * https://leetcode-cn.com/contest/season/2020-fall/problems/nGK0Fy/
 * 1. 速算机器人
 */
public class c1 {

    public int calculate(String s) {
        int res = 0;
        int x = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    public static void main(String[] args) {

    }
}

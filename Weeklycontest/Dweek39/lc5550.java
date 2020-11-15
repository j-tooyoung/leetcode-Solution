package Dweek39;

/**
 * @Classname lc5571
 * @Description
 * 5550. 拆炸弹
 * https://leetcode-cn.com/contest/biweekly-contest-39/problems/defuse-the-bomb/
 *
 * @Date 2020/11/8 22:13
 * @Created by j-tooyoung
 */
public class lc5550 {

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        int len = code.length;
        for (int i = 0; i < code.length; i++) {
            if (k > 0) {
                int j = 1;
                int sum = 0;
                while (j <= k) {
                    sum += code[(i + j) % len];
                    j++;
                }
                res[i] = sum;
            } else if (k < 0) {
                int j = 1;
                int sum = 0;
                int a = Math.abs(k);

                while (j <= a) {
                    sum += code[(i - j + len) % len];
                    j++;
                }
                res[i] = sum;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}

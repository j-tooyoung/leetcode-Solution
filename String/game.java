/**
 * LCP 01. 猜数字
 * https://leetcode-cn.com/problems/guess-numbers/
 */
public class game {
    public int game(int[] guess, int[] answer) {
        int cnt = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                cnt++;
            }
        }
        return cnt;
    }

}

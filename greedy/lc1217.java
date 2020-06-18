/**
 * 1217. 玩筹码
 * https://leetcode-cn.com/problems/play-with-chips/
 */
public class lc1217 {

    public static int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int val : chips) {
            if ((val & 1) == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}

package week230;

import java.util.Arrays;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5690 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int cnt = 0;
        int minVal = Arrays.stream(baseCosts).min().getAsInt();
        if (minVal >= target) {
            return minVal;
        }
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < baseCosts.length; i++) {
                if (dfs1(target - cnt - baseCosts[i], toppingCosts, 0)) {
                    flag = false;
                    return target - cnt;
                }
                if (dfs1(target + cnt - baseCosts[i], toppingCosts, 0)) {
                    flag = false;
                    return target + cnt;
                }
            }
            ++cnt;
        }
        return target;
    }

    private boolean dfs1(int sum, int[] toppingCosts, int idx) {
        if(sum <0)return false;
        if (idx == toppingCosts.length) {
            return sum == 0;
        }
        if (dfs1(sum - toppingCosts[idx], toppingCosts, idx + 1)) {
            return true;
        }
        if (dfs1(sum - 2 * toppingCosts[idx], toppingCosts, idx + 1)) {
            return true;
        }
        if (dfs1(sum, toppingCosts, idx + 1)) {
            return true;
        }

        return false;
    }



}

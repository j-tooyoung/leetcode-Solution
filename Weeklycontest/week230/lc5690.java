package week230;

import java.util.Arrays;

/**
 * @Classname lc5625
 * @Description
 * @Date 2020/12/13 10:33
 * @Created by j-tooyoung
 */
public class lc5690 {

    int ans = -0x3f3f3f3f;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int cnt = 0;
        int minVal = Arrays.stream(baseCosts).min().getAsInt();
        if (minVal >= target) {
            return minVal;
        }
        int n = baseCosts.length;
        for (int i = 0; i < n; i++) {
            dfs1(baseCosts[i], toppingCosts, 0, target);
        }
        return ans;
    }

    private void dfs1(int sum, int[] toppingCosts, int idx, int target) {
        if (idx > toppingCosts.length) {
            return;
        }
        if (idx == toppingCosts.length) {
            if (Math.abs(sum - target) < Math.abs(ans - target) || ((ans > sum) && (Math.abs(sum - target) == Math.abs(ans - target)))) {
                ans = sum;
            }
            return;
        }
        dfs1(sum + toppingCosts[idx], toppingCosts, idx + 1, target);
        dfs1(sum + 2 * toppingCosts[idx], toppingCosts, idx + 1, target);
        dfs1(sum, toppingCosts, idx + 1, target);

    }

//    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//        int cnt = 0;
//        int minVal = Arrays.stream(baseCosts).min().getAsInt();
//        int maxVal = Arrays.stream(baseCosts).max().getAsInt();
//        int sum = Arrays.stream(toppingCosts).sum();
//        if (sum * 2 + maxVal <= target) {
//            return sum * 2 + maxVal;
//        }
//        if (minVal >= target) {
//            return minVal;
//        }
//
//        boolean flag1 = true;
//        boolean flag2 = true;
//        int ans = 0x3f3f3f;
    // brute force todo
//        while ((flag1 || flag2) && cnt < 1500) {
//            for (int i = 0; i < baseCosts.length; i++) {
//                if (flag1 && dfs1(target - cnt - baseCosts[i], toppingCosts, 0)) {
//                    flag1 = false;
//                    if (cnt <= Math.abs(target - ans)) {
//                        ans = target - cnt;
//                    }
//                }
//                if (flag2 && dfs1(target + cnt - baseCosts[i], toppingCosts, 0)) {
//                    flag2 = false;
//                    if (cnt < Math.abs(target - ans)) {
//                        ans = target + cnt;
//                    }
//                }
//            }
//            ++cnt;
//        }
//        return ans;
//    }
//
//    private boolean dfs1(int sum, int[] toppingCosts, int idx) {
//        if (sum < 0) return false;
//        if (idx == toppingCosts.length) {
//            return sum == 0;
//        }
//        if (dfs1(sum - toppingCosts[idx], toppingCosts, idx + 1)) {
//            return true;
//        }
//        if (dfs1(sum - 2 * toppingCosts[idx], toppingCosts, idx + 1)) {
//            return true;
//        }
//        if (dfs1(sum, toppingCosts, idx + 1)) {
//            return true;
//        }
//
//        return false;
//    }

}

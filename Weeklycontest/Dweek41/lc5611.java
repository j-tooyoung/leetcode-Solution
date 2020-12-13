package Dweek41;

import week95.ListNode;

import java.util.Arrays;

/**
 * @Classname lc5665
 * @Description
 * @Date 2020/11/15 23:43
 * @Created by j-tooyoung
 */
public class lc5611 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Arrays.sort(aliceValues);

        return 0;
    }

    public int stoneGameVI1(int[] aliceValues, int[] bobValues) {
        int[] diff = new int[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            diff[i] = aliceValues[i] - bobValues[i];
        }
        int res = 1;
        boolean flag = true;
        return dfs(aliceValues, bobValues, 0, flag, 0, new boolean[aliceValues.length]);
//         res;
    }

    private int dfs(int[] aliceValues, int[] bobValues, int index, boolean flag, int cnt, boolean[] used) {

        if (index >= aliceValues.length) {
            return cnt > 0 ? 1 : (cnt == 0) ? 0 : -1;
        }
        if (flag) {
            cnt += aliceValues[index];
        } else {
            cnt -= bobValues[index];
        }
        for (int i = index; i < aliceValues.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (dfs(aliceValues, bobValues, index + 1, !flag, cnt, used) > 0) {
                return 1;
            }
            used[i] = false;
        }
        return 1;
    }
}

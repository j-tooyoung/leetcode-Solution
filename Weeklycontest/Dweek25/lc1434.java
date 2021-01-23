package Dweek25;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc1434
 * @Description
 * https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other/solution/mei-ge-ren-dai-bu-tong-mao-zi-de-fang-an-d4kd/
 * @Date 2021/1/21 10:22
 * @Created by j-tooyoung
 */
public class lc1434 {
//    状态压缩动态规划
    public int numberWays(List<List<Integer>> hats) {
        int mod = (int) (1e9 + 7);
        int n = hats.size();
        // 找到帽子编号的最大值，这样我们只需要求出 f[maxhatid][2^n - 1] 作为答案
        int maxHatId = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer h : list) {
                maxHatId = Math.max(maxHatId, h);
            }
        }
        // 对于每一顶帽子 h，hatToPerson[h] 中存储了喜欢这顶帽子的所有人，方便进行动态规划
        List<List<Integer>> hatToPerson = new ArrayList<>();
        for (int i = 0; i <= maxHatId; i++) {
            hatToPerson.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer h : list) {
                hatToPerson.get(h).add(i);
            }
        }
        int[][] dp = new int[maxHatId + 1][1 << n];
        dp[0][0] = 1;
        for (int i = 1; i <= maxHatId; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                dp[i][mask] = dp[i - 1][mask];
                // 第j个人选中第i个帽子
                List<Integer> list = hatToPerson.get(i);
                for (int j : list) {
                    if ((mask & (1 << j)) > 0) {
                        dp[i][mask] += dp[i - 1][mask ^ (1 << j)];
                        dp[i][mask] %= mod;
                    }
                }
            }
        }
        return dp[maxHatId][(1 << n) - 1];
//        return dp[maxHatId][1 << n - 1]; 错误，记得加括号
    }

    // dfs 回溯
    public int numberWays1(List<List<Integer>> hats) {
        int mod = (int) (1e9 + 7);
        int n = hats.size();
        // 找到帽子编号的最大值，这样我们只需要求出 f[maxhatid][2^n - 1] 作为答案
        int maxHatId = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer h : list) {
                maxHatId = Math.max(maxHatId, h);
            }
        }
        // 对于每一顶帽子 h，hatToPerson[h] 中存储了喜欢这顶帽子的所有人，方便进行动态规划
        List<List<Integer>> hatToPerson = new ArrayList<>();
        for (int i = 0; i <= maxHatId; i++) {
            hatToPerson.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer h : list) {
                hatToPerson.get(h).add(i);
            }
        }
        dfs(maxHatId, n, hatToPerson,hats);
        return 0;
    }

    private void dfs(int maxHatId, int n, List<List<Integer>> hatToPerson, List<List<Integer>> hats) {
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer h : list) {

            }

        }
    }
}

package week213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname lc5524
 * @Description 5600. 第 K 条最小指令
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/kth-smallest-instructions/
 * @Date 2020/10/25 23:44
 * @Created by j-tooyoung
 */
public class lc5600 {

    /**
     * (二叉查询) O(r+c)
     * 将 H 看做 0，V 看做 1，题目要求的就是字典序第 k 个 01 串。
     * 从高位开始往低位确定数字
     * 如果 0 的剩余个数为 0，则只能填 1。
     * 否则，计算出这一位如果填 0 后，后续共有多少种可能（通过公式 (i−1zero−1) 求出），记为 x
     * 如果 k > x，则说明这一位不应该填 0，需要填 1，同时 k 应该减去 x。
     * 否则，这一位填 0。
     * 可以预处理组合数数组避免整数计算溢出。
     */
    public static String kthSmallestPath(int[] destination, int k) {
        int one = destination[0] ;
        int zero = destination[1];
        int n = one + zero;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        // 求组合数
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        //  for (int[] ints : dp) {
        //     for (int anInt : ints) {
        //         System.out.print(anInt + " ");
        //     }
        //     System.out.println();
        // }
        String ans = "";

        for (int i = n; i >= 1; i--) {
            if (zero == 0) {
                ans += "V";
            } else {
                // 第i位定为0，后续的方案数
                if (k > dp[i-1][zero-1]) {
                    k -= dp[i-1][zero - 1];
                    ans += "V";
                    one--;
                } else {
                    ans += "H";
                    zero--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] num = {2, 3};
        System.out.println(kthSmallestPath(num, 4));
    }

    /**
     * dfs 暴力超时
     */
    List<String> list = new ArrayList<>();
    int row;
    int col;
    int[] dirX = {0, 1};
    int[] dirY = {1, 0};

    public String kthSmallestPath1(int[] destination, int k) {
        row = destination[0];
        col = destination[1];
        dfs(0, 0, new boolean[row + 1][col + 1], new ArrayList<Character>());
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void dfs(int i, int j, boolean[][] vis, List<Character> path) {
        if (i == row && j == col) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : path) {
                sb.append(ch);
            }
            list.add(sb.toString());
        }
        for (int k = 0; k < 2; k++) {
            int newX = i + dirX[k];
            int newY = j + dirY[k];
            if (newX < 0 || newX > row || newY < 0 || newY > col || vis[newX][newY]) {
                continue;
            }
            path.add((k == 0) ? 'H' : 'V');
            vis[newX][newY] = true;
            dfs(newX, newY, vis, path);
            vis[newX][newY] = false;
            path.remove(path.size() - 1);
        }
    }

}

package week210;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5135
 * @Description 5536. 最大网络秩
 * https://leetcode-cn.com/contest/weekly-contest-210/problems/maximal-network-rank/
 * @Date 2020/10/4 13:54
 * @Created by j-tooyoung
 */
public class lc5536 {

    class graph {
        int x, y;

    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] num = new int[n];
//        List<Integer> list = new ArrayList<>();
        boolean[][] conn = new boolean[n][n];
        for (int i = 0; i < roads.length; i++) {
            num[roads[i][0]]++;
            num[roads[i][1]]++;
            conn[roads[i][0]][roads[i][1]] = true;
            conn[roads[i][1]][roads[i][0]] = true;
        }
        System.out.println(num[0]);
        System.out.println(num[1]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = (conn[i][j]) ? num[i] + num[j] - 1 : num[i] + num[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

}

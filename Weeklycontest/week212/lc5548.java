package week212;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname lc5543
 * @Description 5548. 最小体力消耗路径
 * @Date 2020/10/18 20:12
 * @Created by j-tooyoung
 */
public class lc5548 {


    int res = 0;
    int row, col;
    int[] dirX = {-1, 0, 0, 1};
    int[] dirY = {0, -1, 1, 0};


    /**
     * 二分 + bfs
     *
     * 求所有路径上相邻格子之间 高度差绝对值 的 最大值 的最小值，可以往二分方面想
     *
     * 1、通过二分取到某个特定的值x表示，在任意一条路径中，若相邻格子的高度差绝对值 小于等于 x，则表示这两个格子是连通状态
     * 2、使用st[][]数组记录某个点是否被遍历过，从(0, 0)开始进行bfs，观察能否到达(n - 1, m - 1)
     * 3、若该特定值x能从(0, 0)到达(n - 1, m - 1)则把该x值取小，否则取大
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        int l = 0, r = 1000000;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid,heights)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int mid, int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
         boolean[][] vis = new boolean[row][col];
         int prev = 0;
         q.add(new int[]{0, 0});
         vis[0][0] = true;
         while (!q.isEmpty()) {
             int[] node = q.poll();
             if (node[0] == row - 1 && node[1] == col - 1) {
                 return true;
             }
             for (int i = 0; i < 4; i++) {
                 int newX = node[0] + dirX[i];
                 int newY = node[1] + dirY[i];
                 if (newX < 0 || newX >= row || newY < 0 || newY >= col || vis[newX][newY] || Math.abs(heights[newX][newY] - heights[node[0]][node[1]]) > mid) {
                     continue;
                 }
                 q.add(new int[]{newX, newY});
                 vis[newX][newY] = true;            //入队后即标记为访问状态,
             }

         }
         return false;
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] vis = new boolean[row][col];
//        int prev = 0;
//        q.add(new int[]{0, 0});
//
//        while (!q.isEmpty()) {
//            int[] node = q.poll();
//            vis[node[0]][node[1]] = true;
//            if (node[0] == row - 1 && node[1] == col - 1) {
//                return true;
//            }
//            for (int i = 0; i < 4; i++) {
//                int newX = node[0] + dirX[i];
//                int newY = node[1] + dirY[i];
//                if (newX < 0 || newX >= row || newY < 0 || newY >= col || vis[newX][newY] || Math.abs(heights[newX][newY] - heights[node[0]][node[1]]) > mid) {
//                    continue;
//                }
//                q.add(new int[]{newX, newY});
//            }
//
//        }
//        return false;
    }

//    public int minimumEffortPath1(int[][] heights) {
//        row = heights.length;
//        col = heights[0].length;
//        dfs(heights, 0, 0, heights[0][0], new boolean[row][col]);
//        return res;
//    }
//
//    private void dfs(int[][] heights, int i, int j, int prev, boolean[][] vis) {
//
//        vis[i][j] = true;
//        if (i != 0 && j != 0) {
//            res = Math.max(res, Math.abs(heights[i][j] - prev));
//            prev = heights[i][j];
//        }
//        if (i == row - 1 && j == col - 1) {
//            return;
//        }
//
//        for (int k = 0; k < 4; k++) {
//            int newX = i + dirX[i];
//            int newY = j + dirY[i];
//            if (newX < 0 || newX >= row || newY < 0 || newY >= col || vis[newX][newY]) {
//                continue;
//            }
//            dfs(heights, newX, newY, prev, vis);
//        }
//        vis[i][j] = false;
//    }
}

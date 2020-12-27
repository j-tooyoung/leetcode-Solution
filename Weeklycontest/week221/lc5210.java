package week221;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Classname lc5626
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5210 {

//    手动模拟
    public int[] findBall(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] res = new int[col];

        for (int i = 0; i < col; i++) {
            boolean flag = true;
            int k = i;
            for (int j = 0; j < row; j++) {
                if (grid[j][k] == 1) {
                    if (k == col - 1 || grid[j][k + 1] == -1) {
//
                        k = -1;
                        break;
                    }
                    k++;
                } else {
                    if (k == 0 || grid[j][k - 1] == 1) {
                       k = -1;
                        break;
                    }
                    k--;
                }
            }
//            why k
            res[i] = k;
        }
        return res;
    }

// dfs
    public int[] findBall1(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] res = new int[col];

        for (int i = 0; i < col; i++) {
            res[i] = dfs(grid, 0, i);
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i == grid.length) {
            return j;
        }
        if (j + 1 < grid[0].length && grid[i][j] == 1 && grid[i][j + 1] == 1) {
//            dfs(grid, i + 1, j + 1); 不加return错误
           return dfs(grid, i + 1, j + 1);
        }
        if (j >= 1  && grid[i][j] == -1 && grid[i][j - 1] == -1) {
            return dfs(grid, i + 1, j - 1);
        }
        return -1;
    }
}

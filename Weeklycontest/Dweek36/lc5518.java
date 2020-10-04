package Dweek36;

import java.util.HashSet;
import java.util.Set;

/**
 * 5518. 给定行和列的和求可行矩阵
 * https://leetcode-cn.com/contest/biweekly-contest-36/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class lc5518 {

    // 找出每一行和每一列colSUm, rowSum最小的值，将i,j位置设为二者的最小值
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];
        // int zerorow = 0;
        // int zerocol = 0;
        while (true) {
            int x ,y;
            x = y = -1;
            int maxVal = Integer.MAX_VALUE;
            for (int i = 0; i < row; i++) {
                if (rowSum[i] == 0) {
                    // zerorow++;
                    continue;
                }
                if (maxVal >= rowSum[i]) {
                    x = i;
                    maxVal = rowSum[i];
                }
            }
            maxVal = Integer.MAX_VALUE;
            for (int i = 0; i < col; i++) {
                if (colSum[i] == 0 ) {
                    // zerocol++;
                    continue;
                }
                if (maxVal >= colSum[i]) {
                    y = i;
                    maxVal = colSum[i];
                }
            }
            if (x ==-1 || y==-1) break;
            int val = Math.min(colSum[y], rowSum[x]);
            res[x][y] = val;
            colSum[y] -= val;
            rowSum[x] -= val;
            // if (zerocol == col && zerorow == row) {
            //     break;
            // }
        }
        return res;
    }

}

package Dweek18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1329. 将矩阵按对角线排序
 * https://leetcode-cn.com/contest/biweekly-contest-18/problems/sort-the-matrix-diagonally/
 */
public class lc1329 {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
//        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            int x = i;
            int y = 0;
            List<Integer> list = new ArrayList<>();
            while (x < row && y < col) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            x = i;
            y = 0;
            int idx = 0;
            while (x < row && y < col) {
                mat[x++][y++] = list.get(idx++);
            }

        }
        for (int i = 1; i < col; i++) {
            int x = 0;
            int y = i;
            List<Integer> list = new ArrayList<>();
            while (x < row && y < col) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            x = 0;
            y = i;
            int idx = 0;
            while (x < row && y < col) {
                mat[x++][y++] = list.get(idx++);
            }
        }
        return mat;
    }
}

package Dweek34;

/**
 * @Classname lc5491
 * @Description TODO
 * @Date 2020/9/5 22:54
 * @Created by xp123
 * 5491. 矩阵对角线元素的和
 * https://leetcode-cn.com/contest/biweekly-contest-34/problems/matrix-diagonal-sum/
 */
public class lc5491 {

    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int i = 0, j = 0;
        int res = 0;
        while (i < row && j < col) {
            res += mat[i][j];
            i++;
            j++;
        }
        i = 0;
        j = col - 1;
        while (i < row && j >= 0) {
            res += mat[i][j];
            i++;
            j--;
        }
        if (row % 2 == 1) return res - mat[row / 2][row / 2];
        return res;
    }

}

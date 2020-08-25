import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc01_08
 * @Description TODO
 * @Date 2020/8/25 20:23
 * @Created by xp123
 * 面试题 01.08. 零矩阵
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 *
 */
public class lc01_08 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}

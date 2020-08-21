/**
 * 766. 托普利茨矩阵
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class lc766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 第一行遍历
        for (int i = 0; i < col; i++) {
            int r = 0, c = i;
            while (r + 1 < row && c + 1 < col) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
                r++;
                c++;
            }
        }
        // 第一列遍历
        for (int i = 1; i < row; i++) {
            int r = i, c = 0;
            while (r + 1 < row && c + 1 < col) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
                r++;
                c++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}

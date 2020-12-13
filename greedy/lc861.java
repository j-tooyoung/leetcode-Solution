/**
 * 861. 翻转矩阵后的得分
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 */
public class lc861 {

    public int matrixScore(int[][] A) {
        int ans = 0;
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for (int j = 1; j < col; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += A[i][j];
            }
            if (sum < row - sum) {
                for (int i = 0; i < row; i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum = sum * 2 + A[i][j];
            }
            ans += sum;
        }
        return ans;
    }

    public static void main(String[] args) {

    }


}

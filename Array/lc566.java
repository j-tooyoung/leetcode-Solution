/**
 * 566. 重塑矩阵
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 */
public class lc566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int row = nums.length;
        int col = nums[0].length;
        if (row * col < r *c) return nums;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int idx = i * c + j;
                int x = idx / col;
                int y = idx - x * col;
                res[i][j] = nums[x][y];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

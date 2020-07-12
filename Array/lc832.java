/**
 * 832. 翻转图像
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 */
public class lc832 {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A[0].length < 1) return new int[][]{};
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            int lo = 0, hi = col - 1;
            while (lo < hi) {
                int tmp = A[i][lo];
                A[i][lo] = A[i][hi];
                A[i][hi] = tmp;
                A[i][lo] = 1 - A[i][lo];
                A[i][hi] = 1 - A[i][hi];
                hi--;
                lo++;
            }
            //奇数列，中间的数未更新
            if (lo == hi)   A[i][hi] = 1 - A[i][hi];

        }
        return A;
    }

    public static void main(String[] args) {

    }

}

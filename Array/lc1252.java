/**
 * 1252. 奇数值单元格的数目
 * https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class lc1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int ans = 0;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            //行和列分别更新
            for (int j = 0; j < n; j++) {
                matrix[j][indices[i][1]]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[indices[i][0]][j]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += (matrix[i][j] & 1);
            }
        }
        return ans;
    }

}

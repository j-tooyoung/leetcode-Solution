import java.util.HashSet;
import java.util.Set;

/**
 * 840. 矩阵中的幻方
 * https://leetcode-cn.com/problems/magic-squares-in-grid/
 *
 */
public class lc840 {

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        for (int i = 0; i + 3 <= row; i++) {
            for (int j = 0; j + 3 <= col; j++) {
                if (grid[i+1][j+1] != 5) continue;
                if (check(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean check(int[][] grid, int i, int j) {
        int colSum = 0;
        int[] count = new int[16];
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                count[grid[k][l]]++;
            }
        }
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        Set<Integer> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            int rowSum = 0;
            for (int l = j; l < j + 3; l++) {
                rowSum += grid[k][l];
            }
            if (k > i && !set.contains(rowSum)) {
                return false;
            } else {
                set.add(rowSum);
            }
        }
        for (int l = j; l < j + 3; l++) {
            int rowSum = 0;
            for (int k = i; k < i + 3; k++) {
                rowSum += grid[k][l];
            }
            if (!set.contains(rowSum)) {
                return false;
            }
        }
        int x = i;
        int y = j;
        while (x < i + 3) {
            colSum += grid[x++][y++];
        }
        if (!set.contains(colSum)) {
            return false;
        }
        colSum = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        return set.contains(colSum);
    }

}

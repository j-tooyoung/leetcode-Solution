/**
 * 1139. 最大的以 1 为边界的正方形
 * https://leetcode-cn.com/problems/largest-1-bordered-square/
 */
public class lc1139 {

    // dp
//    使用3维数组dp[n + 1][m + 1][2](数组下标从1开始)
    //    dp[i][j][0]:表示第i行第j列的1往 左边 最长连续的1的个数
//        dp[i][j][1]:表示第i行第j列的1往 上面 最长连续的1的个数
//        作者：wzliang
//        链接：https://leetcode-cn.com/problems/largest-1-bordered-square/solution/dpzui-jian-dan-de-dai-ma-by-ri-mu-tu-yuan-12/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int largest1BorderedSquare1(int[][] grid) {
//
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int res = 0, maxLen = Math.min(row, col);
        int[][][] dp = new int[row + 1][col + 1][2];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 0) continue;
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
                //
                int len = Math.min(dp[i][j][0], dp[i][j][1]);
                while (len > 0) {
                    //
                    if (dp[i][j - len + 1][1] >= len && dp[i - len + 1][j][0] >= len) {
                        break;
                    }
                    len--;
                }
                res = Math.max(res, len);
            }
        }
        return res * res;
    }

    //暴力求解
    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int res = 0, maxLen = Math.min(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 1; k <= maxLen; k++) {
                    if (isValid(grid, i, j, k)) {
                        res = Math.max(res, k);
                    }
                }
            }
        }
        return res * res;
    }

    private boolean isValid(int[][] grid, int x, int y, int curLen) {
        int row = grid.length, col = grid[0].length;

        if (x + curLen > row || y + curLen > col) return false;
        //检查边界四个方向是否含有0
        // curLen = 1为自身
        for (int i = x; i < x + curLen; i++) {
            if (grid[i][y] == 0) return false;
            if (grid[i][y + curLen - 1] == 0) return false;
        }
        for (int i = y; i < y + curLen; i++) {
            if (grid[x][i] == 0) return false;
            if (grid[x + curLen - 1][i] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

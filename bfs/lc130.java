import java.util.Arrays;

/**
 * ClassName: lc130
 * Package: PACKAGE_NAME
 * Description:
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @date: 2020/4/8 22:47
 * @author: tooyoung
 */

public class lc130 {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int row, col;
//    问题转化为，如何寻找和边界联通的 O，我们需要考虑如下情况。
    public void solve(char[][] board) {
        if (board == null || board.length == 0|| board[0].length == 0) return;
        row = board.length; col = board[0].length;
//        for (int i = 0; i < row; i++) {
//            if (board[i][0] == 'O') {
//                dfs(board, i, 0);
//            }
//            if (board[i][col-1] == 'O') {
//                dfs(board, i, col-1);
//            }
//        }
//        for (int j = 0; j < col; j++) {
//            if (board[0][j] == 'O') {
//                dfs(board, 0, j);
//            }
//            if (board[row - 1][j] == 'O') {
//                dfs(board, row - 1, j);
//            }
//        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == row - 1 || j == col - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > row - 1  || j > col - 1 || grid[i][j] != 'O' ) {
            return ;
        }
        // 设置（i,j）访问了
        grid[i][j] = 'T';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    public static void main(String[] args) {
        char[][] grid = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
        final lc130 lc130 = new lc130();
        lc130.solve(grid);

//        System.out.println(Arrays.toString(grid));

//        String s ="[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]";

    }
}

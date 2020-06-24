/**
 * ClassName: lc79
 * Package: PACKAGE_NAME
 * Description:
 * 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 *
 * @date: 2020/4/8 22:30
 * @author: tooyoung
 */

public class lc79 {

    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0,};

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int start, String word, boolean[][] vis) {
        int row = board.length, col = board[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || vis[i][j] || word.charAt(start) != board[i][j]) {
            return false;
        }
        if (start == word.length() - 1) {
            return word.charAt(start) == board[i][j];
        }
        vis[i][j] = true;
        // 只要有一条正确路径，返回true
        boolean res = dfs(board, i + 1, j, start + 1, word, vis)
                || dfs(board, i - 1, j, start + 1, word, vis)
                || dfs(board, i, j + 1, start + 1, word, vis)
                || dfs(board, i, j - 1, start + 1, word, vis);
        vis[i][j] = false;
        return res;
    }

    private boolean dfs1(char[][] board, int i, int j, int start, String word, boolean[][] vis) {
        int row = board.length, col = board[0].length;
//        if (i < 0 || j < 0 || i >= row || j >= col || vis[i][j] || word.charAt(start) != board[i][j]) {
//            return false;
//        }

        if (start == word.length() - 1) {
            System.out.println(word.charAt(start));
            return word.charAt(start) == board[i][j];
        } else {
            vis[i][j] = true;
//            System.out.println(i + ", " + j);
//            System.out.println(board[i][j]);
            start += 1;
            System.out.println(start);
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || y < 0 || x >= row || y >= col || vis[x][y] || word.charAt(start) != board[x][y]) {
                    continue;
                }
                // 如果找到，则返回
                if (dfs(board, x, y, start, word, vis)) {
                    return true;
                }
            }
            vis[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";

        char[][] board1 = {{'a', 'b'}};
        String word1 = "ba";
        lc79 solution = new lc79();
        System.out.println(solution.exist(board, word));
        System.out.println(solution.exist(board1, word1));

    }
}

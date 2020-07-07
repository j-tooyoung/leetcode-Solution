/**
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 */
public class lc289 {

    //法1： 生成辅助数组 暴力法
    //法2
//    分析：11 代表细胞活的， 00 代表细胞死的，那么这个位置就四种状态，用【下一个状态，当前状态】表示，最后需要用右移操作更新结果
//
//    状态 0： 00 ，死的，下一轮还是死的
//    状态 1： 01，活的，下一轮死了
//    状态 2： 10，死的，下一轮活了
//    状态 3： 11，活的，下一轮继续活着
//    进一步：下一轮活的可能有两种，也就是要把单元格变为 11
//
//    这个活细胞周围八个位置有两个或三个活细胞，下一轮继续活，属于 11
//    这个细胞本来死的，周围有三个活着的，下一轮复活了，属于 10
//    那遍历下每个格子看他周围细胞有多少个活细胞就行了，然后更改为状态，那么对于第一种可能，把 board[i][j]board[i][j] 设置为 33，对于第二种可能状态设置为 22，设置个高位flag，遍历后面的格子，拿到与他相邻的格子中有多少个 alivealive 的，和 11 与一下即可，最后我们把 board[i][j]board[i][j] 右移 11位，更新结果
//
//    作者：jerry_nju
//    链接：https://leetcode-cn.com/problems/game-of-life/solution/si-lu-jian-dan-yi-dong-zhu-xing-jie-shi-by-jerry_n/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int[] dx = {-1,-1, -1, 0, 0, 1, 1,1};
    int[] dy = {0, -1, 1, -1, 1, -1, 1, 0};

    public void gameOfLife(int[][] board) {

        // need to fix 有问题
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cnt = alive(board, i, j);
                if(board[i][j] == 1) {
                    if(cnt == 2 || cnt == 3) {
                        board[i][j] |= 2;  // 使用第二个bit标记是否存活
                    }
                } else {
                    if(cnt == 3) {
                        board[i][j] |= 2; // 使用第二个bit标记是否存活
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int alive(int[][] board, int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return 0;
            }
            // 加上当前轮的结果
            cnt += (board[x][y] & 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(0 | 2);
        System.out.println(1 | 2);
        System.out.println((1 << 0) + 1);
        System.out.println((1 << 0));
        System.out.println((2 << 1));
    }

}

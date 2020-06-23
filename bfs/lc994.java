import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * https://leetcode-cn.com/problems/rotting-oranges/
 */
public class lc994 {

    public static int orangesRotting(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        // 腐烂的橘子数目
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }

            }
        }
        System.out.println(cnt);
        if (cnt ==0 ) return res;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] points = q.poll();
                int x = points[0];
                int y = points[1];
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) continue;
                    if (grid[newX][newY] == 1) {
                        q.add(new int[]{newX, newY});
                        grid[newX][newY] = -1;
                        cnt--;
                    }
                    if (cnt == 0) return res;
                }
            }
        }
        if (cnt > 0) return -1;
        return res;
    }

    public static void main(String[] args) {

    }
}

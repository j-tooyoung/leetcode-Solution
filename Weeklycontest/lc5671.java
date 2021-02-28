import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname lc5671
 * @Description
 * @Date 2021/2/20 23:32
 * @Created by j-tooyoung
 */
public class lc5671 {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;

        int ans[][] = new int[row][col];
        boolean vis[][] ;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    Queue<int[]> queue = new LinkedList<>();

                    queue.add(new int[]{i, j});
                    vis = new boolean[row][col];
                    vis[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] front = queue.poll();
                        int x = front[0];
                        int y = front[1];
                        System.out.println("x = " + x + " " + "y = " + y);
                        // cout << x << " " << y<<endl;
                        for (int k = 0; k < 4; ++k) {
                            int newX = x + dx[k];
                            int newY = y + dy[k];
                            if (newX < 0 || newX >= row || newY >= col || newY < 0 || isWater[newX][newY] == 1 || vis[newX][newY]) {
                                continue;
                            }
                            if (ans[newX][newY] < 0) {
                                ans[newX][newY] = ans[x][y] + 1;
                            } else {
                                ans[newX][newY] = Math.min(ans[newX][newY], ans[x][y] + 1);
                            }
                            queue.add(new int[]{newX, newY});
                            vis[newX][newY] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

}

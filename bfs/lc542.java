import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 542. 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class lc542 {

    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // int[][] res = new int[row][col];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    //
                    matrix[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col) continue;
                if (matrix[newX][newY] == -1) {
                    // res[newX][newY] = res[x][y] + 1;
                    matrix[newX][newY] = matrix[x][y] + 1;

                    q.add(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    // 超时
    public static int[][] updateMatrix1(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] res = new int[row][col];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        res[i][j] = Math.min(res[i - 1][j], res[i][j - 1])  + 1;
                    } else {
                        Queue<int[]> q = new LinkedList<>();

                        int distance = 0;
                        q.add(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] poll = q.poll();
                            int x_1 = poll[0];
                            int y_1 = poll[1];
                            for (int k = 0; k < 4; k++) {
                                int x = x_1 + dx[k];
                                int y = y_1 + dy[k];
                                if (x < 0 || y < 0 || x >= row || y >= col) {
                                    continue;
                                }
                                if (matrix[x][y] == 0) {
                                    break;
                                }
                                q.add(new int[]{x, y});
                            }
                            distance++;
                        }
                        res[i][j] = distance;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

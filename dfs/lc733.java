/**
 * 733. 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 *
 */
public class lc733 {

    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor != newColor) {
            dfs(image, sr, sc, curColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image,int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= image.length || newY <0 || newY >= image[0].length) continue;
                dfs(image, newX, newY, color, newColor);
            }
        }
    }

    public static void main(String[] args) {

    }

}

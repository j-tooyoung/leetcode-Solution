package week197;

/**
 *
 * https://www.acwing.com/file_system/file/content/whole/index/content/1087703/
 */
public class lc5463 {


    public double getMinDistSum(int[][] positions) {
        int n = positions.length;
        double step = 100000, eps = 1e-6;
        double x = positions[0][0], y = positions[0][1];
        double d = getDist(positions, x, y);
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        while (step > eps) {
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                double a = x + dx[i] * step;
                double b = y + dy[i] * step;
                double dist = getDist(positions, a, b);
                if (dist < d) {
                    //找到更小的，更新x,y,最小距离
                    x = a;
                    y = b;
                    d = dist;
                    flag = true;
                    break;
                }
            }
            //如果找不到更小的，减小步长
            if (!flag) {
                step /= 2;
            }
        }
        return d;
    }

    private double getDist(int[][] positions, double x, double y) {
        double res = 0;
        for (int[] arr : positions) {
            double a = arr[0], b = arr[1];
            res += Math.sqrt((a - x) * (a - x) + (b - y) * (b - y));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

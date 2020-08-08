/**
 *812. 最大三角形面积
 * https://leetcode-cn.com/problems/largest-triangle-area/
 *
 */
public class lc812 {

    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double res = 0;
        for (int i = 0; i < N - 2; ++i) {
            for (int j = i + 1; j < N - 1; ++j) {
                for (int k = j + 1; k < N; ++k) {
                    res = Math.max(res, area(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    double area(int[] p1,int[] p2,int[] p3) {
        int dx1 = p2[0] - p1[0];
        int dx2 = p3[0] - p1[0];
        int dy1 = p2[1] - p1[1];
        int dy2 = p3[1] - p1[1];
        return Math.abs(dx1 * dy2 - dx2 * dy1) / 2.0;
    }
}

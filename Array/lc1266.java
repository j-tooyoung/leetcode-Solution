/**
 * 1266. 访问所有点的最小时间
 * https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
 */
public class lc1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int diffX = points[i + 1][0] - points[i][0];
            int diffY = points[i + 1][1] - points[i][1];
            if (diffX == diffY) {
                res += Math.abs(diffX);
            } else {
                res += Math.max(Math.abs(diffX), Math.abs(diffY));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

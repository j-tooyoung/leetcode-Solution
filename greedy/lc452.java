import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: lc452
 * Package: PACKAGE_NAME
 * Description:
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @date: 2020/4/8 23:14
 * @author: tooyoung
 */
//题解同435

public class lc452 {

    public static int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (points == null || len == 0) {
            return 0;
        }
        if (len == 1) return 1;
        // 不重叠区间的个数
        int res = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            // 相交的，算重叠
            if (points[i][0] <= end) {
                res++;
            } else {
                end = points[i][1];
            }
        }
        return len - res;
    }

    public static void main(String[] args) {

    }
}

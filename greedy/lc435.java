import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class lc435 {

    //    从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
    //把所有与 x 区间相交的区间从区间集合 intvs 中删除。
    //重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        // 比较end值排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;

        for (int i = 0, j = 1; i < intervals.length; ) {
            // 边界条件
            while (j < intervals.length && intervals[i][1] > intervals[j][0]) {
                cnt++;
                j++;
            }
            i = j;
            j = i + 1;
        }
        return cnt;
    }

    public static int eraseOverlapIntervals1(int[][] intervals) {

        if (intervals.length <= 1) return 0;
        // 比较end值排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        int start;
        int end = intervals[0][1];
        //如果区间的起点，小于上一个区间的终点，说明有交集，要删除
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                cnt++;
            } else {
                end = intervals[i][1];
            }
        }
//        for (int[] in : intervals) {
//            start = in[0];
//            if (start >= end) {
//                cnt++;
//                end = in[1];
//            }
//        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervels = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(intervels));

        //  [ [1,2], [2,3], [3,4], [1,3] ]
        // [ [1,2], [1,2], [1,2] ]
        // [ [1,2], [2,3] ]

    }

}

package week216;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5670
 * @Description 5608. 完成所有任务的最少初始能量
 * https://leetcode-cn.com/problems/minimum-initial-energy-to-finish-tasks/
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5608 {

    public int minimumEffort(int[][] tasks) {
        // why todo
        Arrays.sort(tasks, (o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));
//        Arrays.sort(tasks, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] t1, int[] t2) {
//                        return (t1[1] - t1[0] - (t2[1] - t2[0]));
//                    }
//                }
//        );
        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (!canAchieve(tasks, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean canAchieve(int[][] tasks, int mid) {
        for (int[] task : tasks) {
            if (mid >= task[1]) {
                mid -= task[0];
                if (mid < 0) return false;
            } else {
                return false;
            }
        }
        return mid >= 0;
    }
}

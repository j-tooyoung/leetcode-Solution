package week223;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5639 {

    int ans = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] time = new int[k];

        if (k == jobs.length) {
            return Arrays.stream(jobs).max().getAsInt();
        }
        dfs(jobs, time, k, jobs.length-1);
        return ans;
    }

    private void dfs(int[] jobs, int[] time, int k, int idx) {
        if (idx < 0) {
            OptionalInt max = Arrays.stream(time).max();
            //  Arrays.stream(time).forEach(value -> System.out.print(value + " "));
            // System.out.println();
            ans = Math.min(ans, max.getAsInt());
            return;
        }
        for (int i = 0; i < k; i++) {
            if (time[i] + jobs[idx] > ans) {
                continue;
            }
            time[i] += jobs[idx];
            dfs(jobs, time, k, idx - 1);
            time[i] -= jobs[idx];
            // 剪只
            if (time[i] <= 0) {
                break;
            }

        }
    }

    // 更快
//    int ans = Integer.MAX_VALUE;
//
//    public int minimumTimeRequired(int[] jobs, int k) {
//        Arrays.sort(jobs);
//        int[] time = new int[k];
//
//        if (k == jobs.length) {
//            return Arrays.stream(jobs).max().getAsInt();
//        }
//        dfs(jobs, time, k, 0);
//        return ans;
//    }
//
//    private void dfs(int[] jobs, int[] time, int k, int idx) {
//        if (idx == jobs.length) {
//            OptionalInt max = Arrays.stream(time).max();
//            //  Arrays.stream(time).forEach(value -> System.out.print(value + " "));
//            // System.out.println();
//            ans = Math.min(ans, max.getAsInt());
//            return;
//        }
//        for (int i = 0; i < k; i++) {
//            if (time[i] + jobs[idx] > ans) {
//                continue;
//            }
//            time[i] += jobs[idx];
//            dfs(jobs, time, k, idx + 1);
//            time[i] -= jobs[idx];
//            // 每位工人必须干活
//            if (time[i] <= 0) {
//                break;
//            }
//
//        }
//    }
}

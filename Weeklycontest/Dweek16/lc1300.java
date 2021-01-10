package Dweek16;

import java.util.Arrays;

/**
 * @Classname lc1300
 * @Description
 * @Date 2021/1/10 20:43
 * @Created by j-tooyoung
 */
public class lc1300 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int lo = 0, hi = 100_000;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (check(mid, target, arr)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean check(int mid, int target, int[] arr) {

        return false;
    }
}

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
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        int lo = 1, hi = Arrays.stream(arr).max().getAsInt();
        int diff = target;
        int len = arr.length;
        int ans = 0;
        for (int i = lo; i <= hi; i++) {
            int idx = get(arr, i);
            int sum = pre[idx] + i * (len - idx);
            if (Math.abs(sum - target) < diff) {
                diff = Math.abs(sum - target);
                ans = i;
            }
        }
        return ans;
    }

    // 大于i的第一个位置
    private int get(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


}

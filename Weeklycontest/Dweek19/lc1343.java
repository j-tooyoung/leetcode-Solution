package Dweek19;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class lc1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        int res = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + arr[i];
            if (i + 1 >= k && (sum[i + 1] - sum[i + 1 - k]) / k >= threshold) {
                res++;
            }
        }

        return res;
    }
}

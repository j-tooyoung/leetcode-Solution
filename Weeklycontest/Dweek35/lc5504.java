package Dweek35;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc5504
 * @Description TODO
 * @Date 2020/9/19 22:59
 * @Created by xp123
 * 5504. 使数组和能被 P 整除
 * https://leetcode-cn.com/contest/biweekly-contest-35/problems/make-sum-divisible-by-p/
 *
 */
public class lc5504 {

    // 暴力不行
    public int minSubarray(int[] nums, int p) {
//        long total = 0;
        int len = nums.length;
        long[] total = new long[len + 1];
        long[] right = new long[len + 1];
        for (int i = 0; i < len; i++) {
            total[i + 1] = total[i] + nums[i];
        }
        long sum = total[len];
        if (sum < p) {
            return -1;
        }
        if (sum % p ==0) return 0;
        int res = len;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j - i + 1 == len) {
                    continue;
                }
                long tmp = (sum - (total[j + 1] - total[i]));
                if (tmp != 0 && tmp % p == 0) {
                    res = Math.min(res, j - i);
                }
            }
        }
        return res;
    }

    public int minSubarray1(int[] nums, int p) {
        int len = nums.length;
        long sum = 0;
        // 前缀和数组可不用
        long[] total = new long[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        // 边界条件
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum < p) {
            return -1;
        }
        if (sum % p ==0) return 0;
        int res = len;
        for (int i = 0; i < len; i++) {
            total[i + 1] = total[i] + nums[i];
            // 从前缀和中找到删除多少数，才能使得
            int tmp = (int) (p - (sum - total[i + 1]) % p) % p;     // 最后必须模p。
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                res = Math.min(res, i - map.get(tmp));
            }
            map.put((int) (total[i + 1] % p), i);

        }
         return res == len ? -1: res;
    }
}

package Dweek32;

import java.util.HashSet;
import java.util.Set;

/**
 * 5468. 第 k 个缺失的正整数
 * https://leetcode-cn.com/contest/biweekly-contest-32/problems/kth-missing-positive-number/
 */
public class lc5468 {

    public static int findKthPositive(int[] arr, int k) {
        int res = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        while (k > 0) {
            if (!set.contains(res)) {
                k--;
            }
            res++;
        }
        return --res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(findKthPositive(arr, 1));
    }

}

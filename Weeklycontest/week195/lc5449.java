package week195;

import java.util.*;

/**
 * 5449. 检查数组对是否可以被k整除
 * https://leetcode-cn.com/contest/weekly-contest-195/problems/check-if-array-pairs-are-divisible-by-k/
 */
public class lc5449 {

    public static boolean canArrange(int[] arr, int k) {
        int len = arr.length;
        int[] num = new int[k];
        for (int val : arr) {
            // 求余
            num[(val % k + k) % k] += 1;
        }
        // 求余互补的个数相同，则配对成功
        for (int i = 1; i < k; i++) {
            if (num[i] != num[k - i]) {
                return false;
            }
        }
        return num[0] % 2 == 0;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        System.out.println(canArrange(arr, 5));
    }
}

package week196;

import java.util.Arrays;

/**
 * 5452. 判断能否形成等差数列
 * https://leetcode-cn.com/contest/weekly-contest-196/problems/can-make-arithmetic-progression-from-sequence/
 */
public class lc5452 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int sub = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != sub) {
                return false;
            }
        }
        return true;
    }

}

package Dweek33;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 5481. 得到目标数组的最少函数调用次数
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/minimum-numbers-of-function-calls-to-make-target-array/
 */
public class lc5481 {

    // 计算每个数字从0到n，至少需要加几次乘几次，每个数字的加次数累加，乘只需要最大的那个就行
    public static int minOperations(int[] nums) {
        int res = 0;
        int maxMulti = 0;

        for (int i = 0; i < nums.length; i++) {
            int cntMulti = 0;
            int cntAdd = 0;
            while (nums[i] != 0) {
                while (nums[i] % 2 == 0) {
                    nums[i] /= 2;
                    cntMulti++;
                }
                nums[i]--;
                cntAdd++;
            }
            maxMulti = Math.max(maxMulti, cntMulti);
            res += cntAdd;
        }
        return res + maxMulti;
    }


    public static void main(String[] args) {
//        System.out.println(Math.pow(4, 0.5));
        int[] nums = {1, 5};
        int[] nums1 = {123456789,987654321};        // 62
//        System.out.println(minOperations(nums));
        System.out.println(minOperations(nums1));
    }

}

package week192;

import java.util.Arrays;

/**
 *
 */
public class lc5428 {

    //
    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] res = new int[len];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            res[idx++] = nums[i];
            res[idx++] = nums[i + n];
        }
//        for (int i = 0; i < len / 2; i++) {
//            res[2 * i] = nums[i];
//        }
//        for (int i = len / 2; i < len; i++) {
//            res[idx] = nums[i];
//            idx += 2;
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }
}

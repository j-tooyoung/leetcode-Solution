package Dweek30;

import java.util.Arrays;

/**
 *
 */
public class lc5446 {

    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.min(nums[len-4]-nums[0],Math.min(nums[len-3]-nums[1],Math.min(nums[len-2]-nums[2], nums[len-1]-nums[3])));

    }

    public static void main(String[] args) {

    }
}

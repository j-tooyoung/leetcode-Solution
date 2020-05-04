import java.util.Arrays;

/**
 * 1365. 有多少小于当前数字的数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class lc1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
//        Arrays.sort(nums);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i])
                    res[i]++;
            }
        }
        return res;
    }
}

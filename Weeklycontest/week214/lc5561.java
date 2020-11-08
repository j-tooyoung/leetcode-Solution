package week214;

/**
 * @Classname lc5561
 * @Description
 * 5561. 获取生成数组中的最大值
 * https://leetcode-cn.com/contest/weekly-contest-214/problems/get-maximum-in-generated-array/
 * @Date 2020/11/8 10:31
 * @Created by j-tooyoung
 */
public class lc5561 {

    public int getMaximumGenerated(int n) {
        if (n ==0 ) return 0;

        int res = 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i <= n; i++) {
            int left = 2 * i;
            int right = 2 * i + 1;
            if (left >= 2 && left <= n) {
                nums[left] = nums[i];
            }
            if (right >= 2 && right <= n) {
                nums[right] = nums[i] + nums[i + 1];
            }
        }
        for (int num : nums) {
            res = Math.max(res, num);
        }
        return res;
    }
}

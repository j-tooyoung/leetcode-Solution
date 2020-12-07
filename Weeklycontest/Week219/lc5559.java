package Week219;

/**
 * @Classname lc5667
 * @Description
 * https://leetcode-cn.com/contest/biweekly-contest-40/problems/minimum-number-of-removals-to-make-mountain-array/
 * 5559. 得到山形数组的最少删除次数
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5559 {

    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        // Arrays.stream(dp1).forEach(val -> System.out.print(val + " "));
        // System.out.println();
        // Arrays.stream(dp2).forEach(val -> System.out.print(val + " "));
        //       System.out.println();

        int ans = len;
        // todo ?
        for (int i = 0; i < len; i++) {
            // System.out.print(len - dp1[i] - dp2[i] + 1 + " ");
            //
            if (dp1[i] ==1 || dp2[i] == 1) {
                continue;
            }
            ans = Math.min(ans, len - dp1[i] - dp2[i] + 1);
        }
        return  ans;
    }
}

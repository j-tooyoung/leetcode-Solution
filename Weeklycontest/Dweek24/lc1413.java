package Dweek24;

/**
 * @Classname lc1413
 * @Description
 * @Date 2021/1/12 17:37
 * @Created by j-tooyoung
 */
public class lc1413 {

    public int minStartValue(int[] nums) {
        int[] pre = new int[nums.length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
            res = Math.max(res, 1 - pre[i + 1]);
        }

        return res== 0? res +1: res;
    }
}

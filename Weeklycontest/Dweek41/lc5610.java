package Dweek41;

/**
 * @Classname lc5667
 * @Description
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5610 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i ] + nums[i];
        }
        // for (int i : sum) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        for (int i = 0; i < len; i++) {
            res[i] = sum[len] - sum[i + 1] - sum[i];
//            System.out.println(res[i]);

            if (len - i - 1 - i >= 0) {
                res[i] -= nums[i] * (len - i - 1 - i);
            } else {
                res[i] += nums[i] * (i - (len - i - 1));
            }
        }
        return res;

//        int[] diff = new int[len];
//        int[] sum = new int[len];
//        int[] sum2 = new int[len];
//        for (int i = 1; i < len; i++) {
//            diff[i - 1] = nums[i] - nums[i - 1];
//            sum[i] = sum[i - 1] + diff[i - 1];
//            sum2[i] = sum2[i - 1] + sum[i];
//        }
//        for (int i : sum) {
//            System.out.print(i + " ");
//        }
//        for (int i = 0; i < len; i++) {
//            res[i] = sum[i] + sum2[len - 1] - sum2[i];
//        }

    }

    public int[] getSumAbsoluteDifferences1(int[] nums) {
        int[] res = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return res;
    }
}

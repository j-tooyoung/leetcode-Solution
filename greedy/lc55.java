/**
 * ClassName: lc55
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏
 *
 * @date: 2020/4/8 23:14
 * @author: tooyoung
 */

public class lc55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = nums[0] != 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = dp[j];
                }
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * @param nums
     * @return
     */
    public boolean rightMethod(int[] nums) {
//        int k = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > k) return false;
//            k = Math.max(k, i + nums[i]);
//        }
//        return true;
        int rightPos = nums[0];         //最右能到达的位置
        for (int i = 0; i < nums.length; i++) {
            // 如果i位置可以到达
            if (i <= rightPos) {
                rightPos = Math.max(rightPos, i + nums[i]);
                if (rightPos >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        lc55 lc55 = new lc55();
//        int[] nums = {2, 3, 1, 1, 4};
//        System.out.println(lc55.canJump(nums));
//        int[] nums1 = {3, 2, 1, 0, 4};
//        System.out.println(lc55.canJump(nums1));
//
//        int testTime = 1000;
//        boolean flag = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = generateRandom.generateRandomArray();
////            if (!lc55.canJump(arr)) {
////                flag = false;
////                System.out.println("错误测例:");
////                String s = "[";
////                for (int j = 0; j < arr.length - 1; j++) {
////                    s += arr[j] + ",";
////                }
////                s += arr[arr.length - 1] + "]";
////                System.out.println(s);
//////                generateRandom.printArray(arr);
////                break;
////            }
//        }
//        System.out.println();
//        System.out.println(flag ? "nice" : "it's wrong");
    }

}

/**
 * ClassName: lc45
 * Package: PACKAGE_NAME
 * Description:
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @date: 2020/4/8 23:13
 * @author: tooyoung
 */

public class lc45 {

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }
        return dp[nums.length - 1];
    }

    public static int jump1(int[] nums) {
        int cnt = 0;
        //只有一个元素时，返回0
        if (nums.length < 2) return cnt;
        for (int i = 0; i < nums.length; ) {
            // 获取[i+1,left]区间内能跳的最大值，需要保存并更新下一步位置
            int left = i + nums[i];
            if (left >= nums.length - 1) return ++cnt;
            int maxPos = 0;
            int maxVal = 0;
            for (int j = i + 1 ; j <= left; j++) {
                if (j + nums[j] >= maxVal) {
                    maxVal = j + nums[j];
                    maxPos = j;
                }
            }
            i = maxPos;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {2,3,1,1,4};
        int[] nums4 = {1, 2, 1, 1, 1};
        int[] nums5 = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(lc45.jump1(nums1));
        System.out.println(lc45.jump1(nums2));
        System.out.println(lc45.jump1(nums3));
        System.out.println(lc45.jump1(nums4));
        System.out.println(lc45.jump1(nums5));
        System.out.println("--------------");
        System.out.println(lc45.jump(nums1));
        System.out.println(lc45.jump(nums2));
        System.out.println(lc45.jump(nums3));
        System.out.println(lc45.jump(nums4));
        System.out.println(lc45.jump(nums5));
    }

}

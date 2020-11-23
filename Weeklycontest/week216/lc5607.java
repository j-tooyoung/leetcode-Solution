package week216;

/**
 * @Classname lc5669
 * @Description
 * 5607. 生成平衡数组的方案数
 * https://leetcode-cn.com/problems/ways-to-make-a-fair-array/
 *
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5607 {

    //
    public int waysToMakeFair(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[] oddPreSum = new int[len + 2];
        int[] evenPreSum = new int[len + 2];
        int total = 0;
        int odd =0;
        int even=0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        for (int i = 0; i < len; i += 2) {
            evenPreSum[i + 2] = evenPreSum[i] + nums[i];
            even += nums[i];
        }
        for (int i = 1; i < len; i += 2) {
            oddPreSum[i + 2] = oddPreSum[i] + nums[i];
            odd+= nums[i];
        }

        //   for (int i : evenPreSum) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("-------");
        // for (int i : oddPreSum) {
        //     System.out.print(i + " ");
        // }
        for (int i = 0; i < len; i++) {
            int diff = (total - nums[i]);
            if (diff % 2 != 0) {
                continue;
            }
            int partSum = 0;
            if (i % 2 == 0) {
                partSum += (i >= 1) ? oddPreSum[i+1] : 0;
                partSum += even - evenPreSum[i+2];
            } else {
                partSum += (i >= 1) ? evenPreSum[i + 1] : 0;
                partSum += odd - oddPreSum[i+2];
            }
            if (diff - partSum == partSum) {
                ans++;
            }
        }
        return ans;
    }

    // 暴力
    public int waysToMakeFair1(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int diff = (total - nums[i]);
            if (diff % 2 != 0) {
                continue;
            }
            int oddSum = 0;
            for (int j = i + 1; j < len; j += 2) {
                oddSum += nums[j];
            }
            for (int j = i - 2; j >= 0; j -= 2) {
                oddSum += nums[j];
            }
            if (diff - oddSum == oddSum) {
                ans++;
            }
        }
        return ans;
    }
}

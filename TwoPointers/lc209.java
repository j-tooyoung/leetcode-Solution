import java.util.Arrays;

/**
 * ClassName: lc209
 * Package: PACKAGE_NAME
 * Description:
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @date: 2020/4/8 22:41
 * @author: tooyoung
 */

public class lc209 {

    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;
        // 使用stream很慢
//        if (Arrays.stream(nums).sum() < s) {
//            return 0;
//        }
        int total = 0;
        for (int val : nums) {
            total += val;
        }
        if (total < s) return 0;
        int len = nums.length;
        int res = len;
        int sum = 0;
        // j 不断右移， 因此j 的范围为j < len
        while (j <= len) {
            //j 处在满足条件的右侧位置， 所以长度为j - i
            while (sum >= s) {
                res = Math.min(res, j - i );
                sum -= nums[i];
                i++;
            }
            if (j <len)sum += nums[j];
            j++;
        }
        return  res;
        // 写成if else 更慢
//        int i = 0, j = 0;
//        int total = 0;
//        for (int val : nums) {
//            total += val;
//        }
//        if (total < s) return 0;
//        int len = nums.length;
//        int res = len;
//        int sum = 0;
//        while ( j <= len) {
//            if (sum >= s) {
//                res = Math.min(res, j - i );
//                sum -= nums[i];
//                i++;
//            }else{
//                if (j <len)sum += nums[j];
//                j++;
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums1 = {2, 3, 1, 2, 4, 7};
        int[] nums2 = {1, 1};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println(minSubArrayLen(7, nums1));
        System.out.println(minSubArrayLen(3, nums2));

    }
}

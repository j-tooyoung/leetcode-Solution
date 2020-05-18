import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc152
 * Package: PACKAGE_NAME
 * Description:
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @date: 2020/4/8 22:58
 * @author: tooyoung
 */

public class lc152 {

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] minVal = new int[len + 1];
        int[] maxVal = new int[len + 1];
        for (int i = 1; i < len; i++) {
            minVal[i] = nums[i];
            maxVal[i] = nums[i];
        }
        minVal[0] = 1;
        maxVal[0] = 1;
        for (int i = 0; i < len; i++) {
            minVal[i + 1] = Math.min(Math.min(minVal[i] * nums[i], nums[i]), maxVal[i] * nums[i]);
            maxVal[i + 1] = Math.max(Math.max(maxVal[i ] * nums[i], nums[i]), minVal[i] * nums[i]);
            res = Math.max(res, maxVal[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int[] nums1 = {2, 3, -2, 4, -2};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2};
        int[] nums4 = {0, 2};
        int[] nums5 = {0, -2};
        List<int[]> num = new ArrayList<>();
        num.add(nums);
        num.add(nums1);
        num.add(nums2);
        num.add(nums3);
        num.add(nums4);
        num.add(nums5);
        for (int[] arr : num) {
            System.out.println(maxProduct(arr));
        }
    }
}

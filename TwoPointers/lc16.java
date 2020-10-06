import java.util.Arrays;

/**
 * ClassName: lc16
 * Package: PACKAGE_NAME
 * Description:
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @date: 2020/4/8 22:37
 * @author: tooyoung
 */

public class lc16 {

    // 暴力做法
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int total = nums[i] + nums[j] + nums[k];
                    if (Math.abs(total - target) < diff) {
                        diff = Math.abs(total - target);
                        res = total;
                    }
                }
            }
        }
        return res;

    }

    //
    public static int threeSumClosest1(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            int m = i + 1;
            int n = len - 1;
            while (m < n) {
                int total = nums[i] + nums[m] + nums[n];
                if (Math.abs(total - target) < diff) {
                    diff = Math.abs(total - target);
                    res = total;
                }
                if (total > target) {
                    n--;
                } else if (total < target) {
                    m++;
                } else {
                    return total;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}

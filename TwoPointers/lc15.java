import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: lc15
 * Package: PACKAGE_NAME
 * Description:
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @date: 2020/4/8 22:36
 * @author: tooyoung
 */

public class lc15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
//        Arrays.stream(nums).forEach(val -> System.out.println(val));

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
//                i++;  错误，会发生i+2
                continue;
            }
            // System.out.println(nums[i]);

            int m = i + 1;
            int n = len - 1;
//            boolean flag = false;
            while (m < n) {
                // while会继续执行
                //   while (m < n && m > i + 1 && nums[m] == nums[m - 1]) {
                //         m++;
                //     }
                //     while (m < n && n + 1 < len && nums[n] == nums[n + 1]) {
                //         n--;
                //     }
                if (m < n && m > i + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                if (m < n && n + 1 < len && nums[n] == nums[n + 1]) {
                    n--;
                    continue;
                }
                int sum = nums[m] + nums[n] + nums[i];
                if (sum > 0) {
                    n--;
                } else if (sum < 0) {
                    m++;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[m]);
                    path.add(nums[n]);
                    res.add(path);
                    m++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
//        threeSum(nums).forEach(val -> System.out.println(val));
        threeSum(nums1).forEach(val -> System.out.println(val));

    }
}

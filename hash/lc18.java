import java.util.*;

/**
 * @Classname lc18
 * @Description 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 * @Date 2020/10/5 6:39
 * @Created by j-tooyoung
 */
public class lc18 {
    //[-2,-1,-1,1,1,2,2]
//        0
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = len - 1; j >= i + 3; j--) {
                if (j + 1 < len && nums[j] == nums[j + 1]) continue;
                int sum = target - nums[i] - nums[j];
                int m = i + 1;
                int n = j - 1;
                while (m < n) {
                    int total = nums[m] + nums[n];
                    if (m > i + 1 && nums[m] == nums[m - 1]) {
                        m++;
                        continue;
                    }
                    if (n + 1 < j && nums[n] == nums[n + 1]) {
                        n--;
                        continue;
                    }
                    if (total == sum) {
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[i]);
                        path.add(nums[m]);
                        path.add(nums[n]);
                        path.add(nums[j]);
                        res.add(path);
                        m++;
//                        n--;
                    } else if (total > sum) {
                        n--;
                    } else {
                        m++;
                    }
                }

            }

        }
        return res;
    }

    //                Map<Integer, Integer> map = new HashMap<>();
//                // 有重复的跳过
//                for (int k = i + 1; k < j; k++) {
//                    if (map.containsKey(sum - nums[k])) {
//                        List<Integer> path = new ArrayList<>();
//                        path.add(nums[i]);
//                        path.add(nums[map.get(sum - nums[k])]);
//                        path.add(nums[k]);
//                        path.add(nums[j]);
//                        res.add(path);
//                    }
//                    map.put(nums[k], k);
//                }
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums1 = {-2, -1, -1, 1, 1, 2, 2};
//        List<List<Integer>> lists = fourSum(nums, 0);
//        lists.forEach(val -> System.out.println(val));
        fourSum(nums1, 0).forEach(val -> System.out.println(val));

    }
}

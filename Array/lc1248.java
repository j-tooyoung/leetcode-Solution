import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class lc1248 {

    // 前缀和+ map优化
    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化第一个元素
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            cnt[i + 1] = (nums[i] % 2 == 1) ? cnt[i] + 1 : cnt[i];
//            System.out.print(cnt[i + 1]+",");
            map.put(cnt[i + 1], map.getOrDefault(cnt[i + 1], 0) + 1);
            // 如果满足要求
            if (cnt[i + 1] >= k) {
                res += map.get(cnt[i + 1] - k);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int[] nums1 = {2,4,6};
        int[] nums2 = {2,2,2,1,2,2,1,2,2,2};

        System.out.println(numberOfSubarrays(nums, 3));
        System.out.println(numberOfSubarrays(nums1, 1));
        System.out.println(numberOfSubarrays(nums2, 2));

    }
}

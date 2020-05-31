import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class lc1248 {

    public static int numberOfSubarrays(int[] nums, int k) {
//        int len = nums.length;
//        int cnt = 0;
//        int res = 0;
//        for (int i = 0, j = 0; j < len; ) {
//
//            cnt = nums[j] % 2 == 0 ? cnt : ++cnt;
//            j++;
//
//            while (cnt == k) {
//                res++;
//                cnt = nums[i] % 2 == 0 ? cnt : --cnt;
//              i++;
//            }
//        }
//        return res;
//        int len = nums.length;
//        int[] cnt = new int[len + 1];
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] % 2 == 1) {
//                cnt[i + 1] = cnt[i] + 1;
//                map.put(cnt[i + 1], map.getOrDefault(map.get(cnt[i + 1]), 0) + 1);
//            } else {
//                cnt[i + 1] = cnt[i];
//                map.put(cnt[i + 1], map.getOrDefault(map.get(cnt[i + 1]), 0) + 1);
//            }
//            if (map.getOrDefault(cnt[i + 1], 0) >= k) {
//                res += map.getOrDefault(cnt[i + 1] - k, 0);
//            }
//        }
//        return res;
        return 0;
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

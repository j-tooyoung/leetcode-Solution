import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class lc560 {

    //
    // map优化
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                  // preSum数组第一个元素为0
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            // 记录前缀和的数目
            int target = preSum[i + 1] - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(preSum[i + 1], map.getOrDefault(preSum[i + 1], 0) + 1);
        }

        return res;

    }


    // 暴力法
    public static int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
//            System.out.println(preSum[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {  // j
                if (preSum[i + 1] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int[] nums1 = {1, 2, 3};
        System.out.println(subarraySum(nums, 2));
        System.out.println(subarraySum(nums1, 3));

    }
}

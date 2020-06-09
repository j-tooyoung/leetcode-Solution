import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 532. 数组中的K-diff数对
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 */
public class lc532 {

    public static int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        //边界case
        if(k < 0) return 0;
        for (int val : map.keySet()) {
            if (k == 0){
                System.out.println(val);
              if (map.get(val) > 1) res += 2;   //
            } else {
                if (map.containsKey(val + k)) res++;
                if (map.containsKey(val - k)) res++;
            }
        }
        return res>>1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 3, 1, 5, 4};
//        System.out.println(findPairs(nums,2));
//        System.out.println(findPairs(nums1,1));
        System.out.println(findPairs(nums2,0));
    }
}

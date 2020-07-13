import java.util.*;

/**
 *
 */
public class lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums1) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int val : nums2) {
            if (map.containsKey(val) && map.get(val) > 0) {
                list.add(val);
                map.put(val, map.getOrDefault(val, 0) - 1);
            }
        }
//        int[] arr = new int[list.size()];
//        return list.toArray(arr);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}

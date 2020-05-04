import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            if (!set.contains(val)) {
                set.add(val);
            } else {
                return val;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
//        int i = 0, j = nums.length - 1;
//        while (i < j) {
//            int mid = i + j >> 1;
//            int cnt = 0;
//            for (int val : nums) {
//                if (val <= mid) cnt++;
//            }
//            if (cnt > mid - i + 1) {
//                j = mid;
//            } else {
//                i = mid + 1;
//            }
//        }
//        return nums[i];
        return 0;
    }

}

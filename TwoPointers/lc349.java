import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: lc349
 * Package: PACKAGE_NAME
 * Description:
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @date: 2020/4/8 22:41
 * @author: tooyoung
 */

public class lc349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
//        if (nums1.length < nums2)
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                set1.add(num);
            }
        }
        int[] res = new int[set1.size()];
        int idx = 0;
        for (int num : set1) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

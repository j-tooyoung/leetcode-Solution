import java.util.*;

/**
 * ClassName: lc90
 * Package: PACKAGE_NAME
 * Description:
 * 子集ii
 * https://leetcode-cn.com/problems/subsets-ii/
 * @date: 2020/4/8 22:30
 * @author: tooyoung
 */

public class lc90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length < 1) return res;
        Set<List<Integer>> set = new HashSet<>();

        for (int val : nums) {
            List<List<Integer>> output = new ArrayList<>();
            for (List<Integer> path : res) {
                List<Integer> list = new ArrayList<>(path);
                list.add(val);
                if (!set.contains(list)) {
                    set.add(list);
                } else {
                    continue;
                }
                output.add(list);
            }
            for (List<Integer> path : output) {
                res.add(path);
            }
        }
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
//
    }


    public static void main(String[] args) {
        lc90 lc90 = new lc90();
        int[] nums = {1, 2, 2};
        int[] nums3 = {4, 4, 1,4};
        int[] nums1 = {1};
        int[] nums2 = null;
        System.out.println(lc90.subsetsWithDup(nums3));
    }
}

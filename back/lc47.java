import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: lc47
 * Package: PACKAGE_NAME
 * Description:
 * 全排列II
 * @date: 2020/4/8 22:28
 * @author: tooyoung
 */

public class lc47 {

    public static void main(String[] args) {
        final lc47 lc47 = new lc47();
        int[] nums = {1, 1, 3};
        List<List<Integer>> permutation = lc47.permuteUnique(nums);
        //输出
        printArrayList<Integer> pr = new printArrayList<>();
        pr.printArrayList(permutation);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> path, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    path.add(nums[i]);
                } else {
                    continue;
                }

                swap(nums, i, start);
                helper(nums, res, path, start + 1);
//                helper(nums, res, path, i + 1); wrong
                path.remove(path.size() - 1);
                swap(nums, i, start);
            }
        }

    }

    private void swap(int[] nums, int i, int start) {
        int tmp = nums[i];
        nums[i] = nums[start];
        nums[start] = tmp;
    }
}

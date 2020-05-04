import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc46
 * Package: PACKAGE_NAME
 * Description:
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @date: 2020/4/8 22:28
 * @author: tooyoung
 */

public class lc46 {

    public static void main(String[] args) {
        final lc46 lc46 = new lc46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutation = lc46.permutation(nums);
        //输出
        printArrayList<Integer> pr = new printArrayList<>();
        pr.printArrayList(permutation);
    }

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> path, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < nums.length; i++) {
                // wrong
//                swap(nums, i, start);
//                path.add(nums[i]);
                path.add(nums[i]);
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

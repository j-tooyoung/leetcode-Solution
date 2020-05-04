import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: lc78
 * Package: PACKAGE_NAME
 * Description:
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 * @date: 2020/4/8 22:29
 * @author: tooyoung
 */

public class lc78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(new lc78().subsets1(nums).toString());

    }

    // 递归
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length < 1) return res;
        for (int val : nums) {
            List<List<Integer>> output = new ArrayList<>();
            for (List<Integer> path : res) {
                List<Integer> list = new ArrayList<>(path);
                list.add(val);
                output.add(list);
            }
            for (List<Integer> path : output) {
                res.add(path);
            }
        }
        return res;
    }


    // 回溯
    public  List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private  void helper(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        // 符和条件加入res
        // path会变
//        res.add(path);
        res.add(new ArrayList<>(path));
        // 做选择
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, res, path, i + 1);
            path.remove(path.size() - 1);

        }
    }
}

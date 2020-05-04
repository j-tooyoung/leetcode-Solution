import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc113
 * Package: PACKAGE_NAME
 * Description:
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @date: 2020/4/8 22:54
 * @author: tooyoung
 */

public class lc113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        } else {

            helper(root.left, sum - root.val, res, path);
            helper(root.right, sum - root.val, res, path);
        }
    }

    public static void main(String[] args) {

    }

}

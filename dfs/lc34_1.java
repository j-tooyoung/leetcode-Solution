import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class lc34_1 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
//        if (sum < 0) return;
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);
//        System.out.println(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum, path);
        dfs(root.right, sum, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

    }

}

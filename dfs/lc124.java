/**
 * ClassName: lc124
 * Package: PACKAGE_NAME
 * Description:
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @date: 2020/4/8 22:54
 * @author: tooyoung
 */

public class lc124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int sum = 0;
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        dfs(root, sum);
        return res;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left, sum)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, dfs(root.right, sum));
        if (root.val + left + right > res) {
            res = root.val + left + right;
        }

        return root.val + Math.max(left, right);
    }


}

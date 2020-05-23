/**
 * 814. 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class lc814 {

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) return null;
//        后序遍历先考虑子节点是否可以删
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 错误
//        pruneTree(root.left);
//        pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}

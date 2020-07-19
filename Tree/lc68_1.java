/**
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 */
public class lc68_1 {

    //自上而下搜索
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //结束条件
        if (root == null) return root;
        if (root.val <= q.val && root.val >= p.val) return root;
        if (root.val <= p.val && root.val >= q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

}

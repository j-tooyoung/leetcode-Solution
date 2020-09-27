/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 */
public class lc235 {

    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val >= p.val && root.val <= q.val) return root;
        else if (q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    // 递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    // 非递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val >= p.val && root.val <= q.val) return root;
        else if (q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}

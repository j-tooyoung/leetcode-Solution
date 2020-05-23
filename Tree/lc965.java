/**
 * 965. 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
public class lc965 {

    public boolean isUnivalTree(TreeNode root) {

        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if(root == null) return true;
        return helper(root.left, val) && helper(root.right, val) && root.val == val;    }

}

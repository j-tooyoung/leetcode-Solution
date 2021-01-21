package week117;

import BST.TreeNode;

/**
 * @Classname lc905
 * @Description
 * @Date 2021/1/21 10:47
 * @Created by j-tooyoung
 */
public class lc965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left, root.val) &&
                dfs(root.right, root.val);
    }
}

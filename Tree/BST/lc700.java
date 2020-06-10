package BST;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class lc700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val || root == null) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) :  searchBST(root.right, val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        if (root.val > val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return null;
    }

}

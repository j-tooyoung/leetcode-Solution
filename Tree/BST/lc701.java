package BST;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class lc701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }


    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode pre = root;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            cur = (cur.val < val) ? cur.right : cur.left;
        }
        TreeNode node = new TreeNode(val);
        if (pre.val < val) {
            pre.right = node;
        } else {
            pre.left = node;
        }
        return root;
//        while (true) {
//            if (cur.val < val) {
//                pre = cur;
//                cur = cur.right;
//                if (cur == null) {
//                    pre.right = new TreeNode(val);
//                    break;
//                }
//            } else {
//                pre = cur;
//                cur = cur.left;
//                if (cur == null) {
//                    pre.left = new TreeNode(val);
//                    break;
//                }
//            }
//        }
//        return root;
    }

}

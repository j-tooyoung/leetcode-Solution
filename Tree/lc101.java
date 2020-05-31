/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
//public class lc101 {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isSymmetric(root.left, root.right);
//    }
//
//    private boolean isSymmetric(TreeNode left, TreeNode right) {
//        if (left == null && right == null) return true;
//        if (left == null || right == null) return false;
//        return left.val == right.val && isSymmetric(left.left, right.right)
//                && isSymmetric(left.right, right.left);
//    }
//}

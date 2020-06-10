package BST;

import java.util.*;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class lc98 {
    // 递归
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!helper(root, 0)) return false;
        return isValidBST(root.right) && isValidBST(root.left);
    }

    //
    private boolean helper(TreeNode root, int val) {
        if (root.right == null && root.left == null) return true;
        if (root.left != null && root.right == null) return (root.val > root.left.val && root.left.val > val);
        if (root.left == null && root.right != null) return root.val < root.right.val;

        if (root.val > root.right.val || root.val < root.left.val) {
            return false;
        }
//        return helper(root.left, )
        return false;
    }

    // 迭代  中序遍历 左中右
    public boolean isValidBST1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return true;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node = root;
//        int preVal = Integer.MIN_VALUE;
        long preVal = Long.MIN_VALUE;
        while (node != null || !st.isEmpty()) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.poll();
            if (node.val < preVal) {
                return false;
            } else {
                preVal = node.val;
            }
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        // 测试用例
//        [10,5,15,null,null,6,20]
        // [1,1]
//        [-2147483648]
    }

}

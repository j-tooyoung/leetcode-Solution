package BST;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class lc450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {

        }
        if (root.val > key) deleteNode(root.left, key);
        if (root.val < key) deleteNode(root.right, key);
        return root;
    }


}

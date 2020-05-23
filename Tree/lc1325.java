/**
 * 1325. 删除给定值的叶子节点
 * https://leetcode-cn.com/problems/delete-leaves-with-a-given-value/
 */
public class lc1325 {

    // 后续遍历删除节点
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root == null) return root;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}

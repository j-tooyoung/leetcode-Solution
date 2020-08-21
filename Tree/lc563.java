/**
 * 563. 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 *
 */
public class lc563 {

    // 速度过慢 有待优化
    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = sum(root.left);
        int rightVal = sum(root.right);
        return Math.abs(leftVal - rightVal) + findTilt(root.left) + findTilt(root.right);
    }


    private static int sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        TreeNode_Factory treeNode_factory = new TreeNode_Factory();
        TreeNode root = treeNode_factory.produce("[1,2,3,4,5]");
        System.out.println(sum(root));
    }

}

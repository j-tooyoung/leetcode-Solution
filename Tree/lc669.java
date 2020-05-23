/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class lc669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        //下面两个if相当于删除不满足要求的节点
        if (root.val < L)
            return trimBST(root.right, L, R);//返回修剪过的右子树。抱有一丝丝期望，希望右子树能够满足要求，因为右子树的值大于当前根节点的值
        if (root.val > R)
            return trimBST(root.left, L, R);//返回修剪过的左子树，抱有一丝丝期望，希望左子树能够满足要求，因为左子树的值小于当前根节点的值

        //处理正常的节点
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return root;
        // 后续遍历
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        if(root.val < L) return root = root.right;
        if(root.val > R) return root = root.left;
        // 介于二者之间,不处理

        return root;
    }

}

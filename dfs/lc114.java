/**
 * ClassName: lc114
 * Package: PACKAGE_NAME
 * Description:
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @date: 2020/4/8 22:54
 * @author: tooyoung
 */

public class lc114 {

    // ?
    TreeNode last = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }

    public static void main(String[] args) {

    }

}

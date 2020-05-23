/**
 *
 */
public class lc105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) return null;
        int len = preorder.length - 1;
        return buildTree(preorder, 0, len, inorder, 0, len);

    }

    private TreeNode buildTree(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2) {
        if (p1 >p2 || i1 > i2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        int i;
        for (i = i1; i <= i2; i++) {
            if (inorder[i] == preorder[p1]) break;
        }
        root.left = buildTree(preorder, p1 + 1, p1 + i - i1, inorder, i1, i - 1);
        root.right = buildTree(preorder, p1 + i - i1 + 1, p2, inorder, i + 1, i2);
        return root;
    }

    public static void main(String[] args) {

    }
}

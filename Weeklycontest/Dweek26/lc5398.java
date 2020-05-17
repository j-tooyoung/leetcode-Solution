package Dweek26;

public class lc5398 {

    int res = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return res;
        helper(root, root.val);
        return res;
    }

    private void helper(TreeNode root, int maxVal) {
        if (root == null) return ;
        maxVal = Math.max(maxVal, root.val);
        if (root.val >= maxVal) res++;
        helper(root.left, maxVal);
        helper(root.right, maxVal);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

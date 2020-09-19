import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class lc404 {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return res;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

    public int sumOfLeftLeaves1(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if (tmp.left != null && tmp.left.left == null && tmp.left.right == null) {
                    res += tmp.left.val;
                }
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
        }
        return res ;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}

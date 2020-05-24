import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class lc94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.add(cur);
                cur = cur.left;
            }
            if (!st.isEmpty()) {
                cur = st.pop();
                res.add(cur.val);
            }
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

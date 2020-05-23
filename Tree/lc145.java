import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class lc145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();

        TreeNode cur = root;
        while (!st.isEmpty() && cur != null) {
            while (cur != null) {
                st.add(cur);
                cur = cur.left;
            }
            cur = st.pop();

            if (cur.right != null) cur = cur.right;
        }
        return res;
    }

    //
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();

        TreeNode cur = root;
        while (!st.isEmpty() && cur != null) {
            while (cur != null) {
                st.add(cur);
                cur = cur.left;
            }
            cur = st.pop();

            if (cur.right != null) cur = cur.right;
        }
        return res;
    }


    // ? 先序遍历，逆转 中左右 左右中
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        TreeNode cur = root;
        while (!st.isEmpty() ) {
            TreeNode node = st.pop();
            res.addFirst(node.val);

            if (node.left != null) {
                st.add(node.left);
            }
            if (node.right != null) {
                st.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

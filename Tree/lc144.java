import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class lc144 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //方法: 迭代
    // 自顶向下，自左向右
    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return list;
    }

    //方法 2：莫里斯遍历



    public static void main(String[] args) {

    }

}

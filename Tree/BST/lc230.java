package BST;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class lc230 {

    //性能提升
    public static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        while (true) {
            while (!st.isEmpty() || root != null) {
                while (root != null) {
                    st.addLast(root);
                    root = root.left;
                }
                root = st.removeLast();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }

    public static int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int idx = 0;
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            idx++;
            if (idx == k) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}

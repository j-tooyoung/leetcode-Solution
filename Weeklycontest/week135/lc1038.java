package week135;

import BST.TreeNode;

import java.util.Stack;

/**
 * @Classname lc1038
 * @Description
 * @Date 2021/1/22 11:15
 * @Created by j-tooyoung
 */
public class lc1038 {
    int sum ;
    public TreeNode convertBST(TreeNode root) {
        sum =0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root ==null) return;
        dfs(root.right);
        sum  += root.val;
        root.val= sum;

        dfs(root.left);

    }

    // 迭代
    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.right;    // 右
            } else {
                TreeNode node = st.pop();
                sum += node.val;
                node.val = sum;
                if (node.left != null) {
                    cur = node.left;
                }
            }
        }
        return root;
    }

}

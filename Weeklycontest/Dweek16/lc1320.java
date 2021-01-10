package Dweek16;

import BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname lc1320
 * @Description
 * @Date 2021/1/10 20:50
 * @Created by j-tooyoung
 */
public class lc1320 {

    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int total = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                total += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans = total;
        }
        return ans;
    }
}
